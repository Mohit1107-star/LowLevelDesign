package org.example.model;

import java.time.Duration;

public class BaseService implements Service {
    private final String id;
    private final String title;
    private final String description;
    private final double price;
    private final Duration duration;

    public BaseService(String id, String title, String description, double price, Duration duration) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.price = price;
        this.duration = duration;
    }

    @Override
    public String getId() {
        return id;
    }

    @Override
    public String getTitle() {
        return title;
    }

    @Override
    public String getDescription() {
        return description;
    }

    @Override
    public double getPrice() {
        return price;
    }

    @Override
    public Duration getDuration() {
        return duration;
    }
}
