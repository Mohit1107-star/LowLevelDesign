package org.example.serviceimpl;

import org.example.model.BaseService;

import java.time.Duration;

public class CleaningService extends BaseService {
    public CleaningService(String id, String description, double price, Duration duration) {
        super(id, "Cleaning Service", description, price, duration);
    }
}
