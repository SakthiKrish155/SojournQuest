package com.sojournquest.sq.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.sojournquest.sq.model.Booked;
import com.sojournquest.sq.model.User;
import com.sojournquest.sq.repository.BookedRepository;
import com.sojournquest.sq.repository.UserRepo;

import jakarta.transaction.Transactional;

@Service
public class BookedService {

    @Autowired
    private BookedRepository br;
    @Autowired
    private UserRepo userRepository;
    public Object getAllBookings;

    @Transactional
    public Booked createBookingForUser(Long userId, Booked book) {
        // Retrieve the user from the database
        Optional<User> userOptional = userRepository.findById(userId);

        if (userOptional.isPresent()) {
            User user = userOptional.get();
            book.setUser(user);
            user.getBook().add(book);
            return br.save(book);
        } else {
            // Handle the case where user is not found
            throw new RuntimeException("User not found with id: " + userId);
        }
    }

    public List<Booked> getBookingsByUserId(Long userId) {
        Optional<User> userOptional = userRepository.findById(userId);

        if (userOptional.isPresent()) {
            User user = userOptional.get();
            return br.findByUser(user);
        } else {
            throw new RuntimeException("User not found with id: " + userId);
        }
    }

    public Booked updateBookingForUser(Long userId, Long bookingId, Booked updatedBooking) {
        Optional<Booked> optionalBooking = br.findById(bookingId);

        if (optionalBooking.isPresent()) {
            Booked existingBooking = optionalBooking.get();
            User bookingUser = existingBooking.getUser();
            if (bookingUser != null && bookingUser.getId().equals(userId)) {
                existingBooking.setRoomTypes(updatedBooking.getRoomTypes());
                return br.save(existingBooking);
            } else {
                throw new RuntimeException("Booking not found for the specified user");
            }
        } else {
            throw new RuntimeException("Booking not found");
        }
    }

    public void deleteBookingForUser(Long userId, Long bookingId) {
        Optional<Booked> optionalBooking = br.findById(bookingId);

        if (optionalBooking.isPresent()) {
            Booked existingBooking = optionalBooking.get();
            User bookingUser = existingBooking.getUser();
            if (bookingUser != null && bookingUser.getId().equals(userId)) {
                br.delete(existingBooking);
            } else {
                throw new RuntimeException("Booking not found for the specified user");
            }
        } else {
            throw new RuntimeException("Booking not found");
        }
    }

    public List<Booked> pageSort(int offset, int pagesize, String field) {
       return  br.findAll(PageRequest.of(offset,pagesize).withSort(Sort.by(Sort.Direction.ASC,field))).getContent();
    }
}
