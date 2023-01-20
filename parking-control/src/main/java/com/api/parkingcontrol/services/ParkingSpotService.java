package com.api.parkingcontrol.services;

import com.api.parkingcontrol.models.ParkingSpotModel;
import com.api.parkingcontrol.repositories.ParkingSpotRepo;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ParkingSpotService {

    @Autowired /*dependency injection of parking spot repo*/
    public ParkingSpotRepo PSRepo;

    @Transactional
    public ParkingSpotModel save(ParkingSpotModel PSmodel) {
        return PSRepo.save(PSmodel); //add na DB e retorna mensagem de status
    }
}
