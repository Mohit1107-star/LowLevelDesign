package org.example;

import org.example.factory.ServiceFactory;
import org.example.model.Booking;
import org.example.model.Service;
import org.example.model.ServiceType;
import org.example.platform.ServicePlatform;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.List;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        ServicePlatform platform = ServicePlatform.getInstance();

        // ✅ Create a Cleaning service
        Booking cleaningBooking = platform.createService(
                "user-001",
                "company-ACME",
                ServiceType.CLEANING,
                "svc-001",
                "2BHK cleaning",
                1499.0,
                Duration.ofHours(2),
                LocalDateTime.now().plusDays(1)
        );

        System.out.println("Created Booking: " + cleaningBooking.getBookingId());

        // ✅ Mark booking as completed
        platform.completeBooking(cleaningBooking.getBookingId());

        // ✅ Fetch all previous (completed) services for user
        List<Booking> history = platform.getPreviousServices("user-001");
        System.out.println("\nCompleted Bookings:");
        for (Booking booking : history) {
            System.out.println("- " + booking.getService().getTitle() +
                    " | ₹" + booking.getService().getPrice() +
                    " | Status: " + booking.getStatus());
        }
    }
}