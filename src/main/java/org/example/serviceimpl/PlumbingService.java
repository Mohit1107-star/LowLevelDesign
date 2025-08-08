package org.example.serviceimpl;

import org.example.model.BaseService;

import java.time.Duration;

public class PlumbingService extends BaseService {
    public PlumbingService(String id, String description, double price, Duration duration) {
        super(id, "Plumbing Service", description, price, duration);
    }
}
