package com.api.parkingcontrol.controllers;

import com.api.parkingcontrol.DataTransferObjects.ParkingSpotDTO;
import com.api.parkingcontrol.models.ParkingSpotModel;
import com.api.parkingcontrol.services.ParkingSpotService;

import jakarta.validation.Valid;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.time.ZoneId;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/parking-spot")
public class ParkingSpotController {

    @Autowired
    public ParkingSpotService PSservice;

    @PostMapping
    public ResponseEntity<Object> save(@RequestBody @Valid ParkingSpotDTO PSDTO){
        var PSmodel = new ParkingSpotModel(); //novo model de parking spot | novo registo
        PSmodel.setRegistrationDate(LocalDateTime.now(ZoneId.of("UTC")));
        BeanUtils.copyProperties(PSDTO, PSmodel);
        return ResponseEntity.status(HttpStatus.CREATED).body(PSservice.save(PSmodel));
    }
}
