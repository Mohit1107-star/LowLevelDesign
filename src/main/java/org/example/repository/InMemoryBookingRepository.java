package org.example.repository;

import org.example.model.Booking;
import org.example.model.BookingStatus;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;

public class InMemoryBookingRepository implements BookingRepository{

    private final Map<String, Booking> store = new ConcurrentHashMap<>();

    @Override
    public void save(Booking booking) {
        store.put(booking.getBookingId(), booking);
    }

    @Override
    public Optional<Booking> findById(String bookingId) {
        return Optional.ofNullable(store.get(bookingId));
    }

    @Override
    public List<Booking> findByUserAndStatus(String userId, BookingStatus status) {
        return store.values().stream()
                .filter(b -> b.getUserId().equals(userId) && b.getStatus() == status)
                .sorted(Comparator.comparing(Booking::getCreatedAt).reversed())
                .collect(Collectors.toList());

    }
}
