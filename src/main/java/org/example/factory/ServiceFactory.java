package org.example.factory;

import org.example.model.Service;
import org.example.model.ServiceType;
import org.example.serviceimpl.ACRepairService;
import org.example.serviceimpl.CleaningService;
import org.example.serviceimpl.PlumbingService;

import java.time.Duration;

public class ServiceFactory {

    public Service createService(ServiceType type, String id, String description, double price, Duration duration){
        return switch (type){
            case CLEANING -> new CleaningService(id,description,price,duration);
            case PLUMBING -> new PlumbingService(id,description,price,duration);
            case AC_REPAIR -> new ACRepairService(id,description,price,duration);
        };
    }
}
