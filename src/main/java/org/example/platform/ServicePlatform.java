package org.example.platform;

import org.example.factory.ServiceFactory;
import org.example.model.Booking;
import org.example.model.BookingStatus;
import org.example.model.Service;
import org.example.model.ServiceType;
import org.example.repository.BookingRepository;
import org.example.repository.InMemoryBookingRepository;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

public class ServicePlatform {

    //Singleton Pattern + Façade + Service Layer
    //Singleton instance (classic lazy-loaded, thread-safe)
    private static ServicePlatform instance;

    public static synchronized ServicePlatform getInstance() {
        if (instance == null) {
            instance = new ServicePlatform();
        }
        return instance;
    }

    private final BookingRepository bookingRepo;
    private final ServiceFactory factory;

    private ServicePlatform() {
        this.bookingRepo = new InMemoryBookingRepository();
        this.factory = new ServiceFactory();
    }

    //- private
    //Keeps these components hidden from outside classes
    //Promotes encapsulation (OOP principle)
    // - final
    //Ensures they can only be assigned once (in the constructor)
    //Prevents accidental reassignment or mutation
    //Makes your class safer, more predictable

    // ✅ API 1: Create a booking
    public Booking createService(String userId, String companyId,
                                 ServiceType type, String serviceId, String description,
                                 double price, Duration duration, LocalDateTime scheduledFor) {

        Service service = factory.createService(type, serviceId, description, price, duration);
        String bookingId = UUID.randomUUID().toString();

        Booking booking = new Booking(
                bookingId,
                userId,
                companyId,
                service,
                scheduledFor,
                LocalDateTime.now(),
                BookingStatus.SCHEDULED
        );

        bookingRepo.save(booking);
        return booking;
    }

    // ✅ API 2: Mark booking completed
    public void completeBooking(String bookingId) {
        bookingRepo.findById(bookingId).ifPresent(Booking::markCompleted);
    }

    // ✅ API 3: Get all previous completed bookings for a user
    public List<Booking> getPreviousServices(String userId) {
        return bookingRepo.findByUserAndStatus(userId, BookingStatus.COMPLETED);
    }
}
