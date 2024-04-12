package com.sojournquest.sq.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sojournquest.sq.model.Booked;
import com.sojournquest.sq.service.BookedService;

@RestController
@RequestMapping("/api/bookers")
public class BookedController {

    @Autowired
    private BookedService bookService;

    @PostMapping("/create/{userId}")
    public ResponseEntity<?> createBookForUser(@PathVariable Long userId, @RequestBody Booked book) {
        try {
            Booked createdBook = bookService.createBookingForUser(userId, book);
            return new ResponseEntity<>(createdBook, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>("Error found", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/get/{userId}/bookings")
    public ResponseEntity<List<Booked>> getBookingsByUserId(@PathVariable Long userId) {
        try {
            List<Booked> bookings = bookService.getBookingsByUserId(userId);
            return new ResponseEntity<>(bookings, HttpStatus.OK);
        } catch (RuntimeException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    @PutMapping("/update/{userId}/booking/{bookingId}")
    public ResponseEntity<?> updateBookingByUserId(@PathVariable Long userId,
                                                    @PathVariable Long bookingId,
                                                    @RequestBody Booked updatedBooking) {
        try {
            Booked updatedBook = bookService.updateBookingForUser(userId, bookingId, updatedBooking);
            return new ResponseEntity<>(updatedBook, HttpStatus.OK);
        } catch (RuntimeException e) {
            return new ResponseEntity<>("Booking not found", HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/delete/{userId}/booking/{bookingId}")
    public ResponseEntity<?> deleteBookingByUserId(@PathVariable Long userId,
                                                    @PathVariable Long bookingId) {
        try {
            bookService.deleteBookingForUser(userId, bookingId);
            return new ResponseEntity<>("Booking deleted successfully", HttpStatus.OK);
        } catch (RuntimeException e) {
            return new ResponseEntity<>("Booking not found", HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/pagesort/{offset}/{pagesize}/{field}")
    public ResponseEntity<?>pageSort(@PathVariable int offset,@PathVariable int pagesize,@PathVariable String field){
        try {
            return new ResponseEntity<>(bookService.pageSort(offset,pagesize,field),HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

}
