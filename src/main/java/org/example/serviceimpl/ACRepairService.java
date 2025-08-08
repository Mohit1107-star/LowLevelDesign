package org.example.serviceimpl;

import org.example.model.BaseService;

import java.time.Duration;

public class ACRepairService extends BaseService {
    public ACRepairService(String id, String description, double price, Duration duration) {
        super(id, "AC repair", description, price, duration);
    }
}
