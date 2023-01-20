package com.api.parkingcontrol.services;

import com.api.parkingcontrol.repositories.ParkingSpotRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ParkingSpotService {

    @Autowired /*dependency injection of parking spot repo*/
    public ParkingSpotRepo PSRepo;
}
