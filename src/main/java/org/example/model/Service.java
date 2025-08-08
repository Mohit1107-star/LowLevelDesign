package org.example.model;
import java.time.Duration;

public interface Service {
    String getId();
    String getTitle();
    String getDescription();
    double getPrice();
    Duration getDuration();
}
