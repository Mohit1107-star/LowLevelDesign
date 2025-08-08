package org.example.model;

import java.time.LocalDateTime;

public class Booking {
    private final String bookingId;
    private final String userId;
    private final String companyId;
    private final Service service;
    private final LocalDateTime scheduledFor;
    private final LocalDateTime createdAt;
    private BookingStatus status;

    public Booking(String bookingId, String userId, String companyId, Service service, LocalDateTime scheduledFor, LocalDateTime createdAt,BookingStatus status) {
        this.bookingId = bookingId;
        this.userId = userId;
        this.companyId = companyId;
        this.service = service;
        this.scheduledFor = scheduledFor;
        this.createdAt = createdAt;
        this.status = status;
    }

    public String getBookingId() {
        return bookingId;
    }

    public String getUserId() {
        return userId;
    }

    public String getCompanyId() {
        return companyId;
    }

    public Service getService() {
        return service;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public LocalDateTime getScheduledFor() {
        return scheduledFor;
    }

    public BookingStatus getStatus() {
        return status;
    }

    public void markCompleted(){
        this.status = BookingStatus.COMPLETED;
    }

    public void cancel(){
        this.status = BookingStatus.CANCELLED;
    }

    @Override
    public String toString() {
        return "Booking{" +
                "bookingId='" + bookingId + '\'' +
                ", userId='" + userId + '\'' +
                ", companyId='" + companyId + '\'' +
                ", service=" + service +
                ", scheduledFor=" + scheduledFor +
                ", createdAt=" + createdAt +
                ", status=" + status +
                '}';
    }
}
