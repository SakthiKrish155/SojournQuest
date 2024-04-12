package com.sojournquest.sq.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

import com.sojournquest.sq.model.Booked;
import com.sojournquest.sq.model.User;

public interface BookedRepository extends JpaRepository<Booked, Long> {
    List<Booked> findByUser(User user);

}