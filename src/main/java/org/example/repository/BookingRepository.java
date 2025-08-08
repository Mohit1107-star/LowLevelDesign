package org.example.repository;

import org.example.model.Booking;
import org.example.model.BookingStatus;

import java.util.List;
import java.util.Optional;

public interface BookingRepository {

    //Repository Pattern
    //Abstracts away persistence logic from business logic
    //Allows switching storage (in-memory → DB) with zero changes to core code


    void save(Booking booking);
    Optional<Booking> findById(String bookingId);
    List<Booking> findByUserAndStatus(String userId, BookingStatus status);
}
