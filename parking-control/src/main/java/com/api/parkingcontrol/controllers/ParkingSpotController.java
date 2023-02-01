package com.api.parkingcontrol.controllers;

import com.api.parkingcontrol.DataTransferObjects.ParkingSpotDTO;
import com.api.parkingcontrol.models.ParkingSpotModel;
import com.api.parkingcontrol.services.ParkingSpotService;

import jakarta.validation.Valid;
import org.json.simple.JSONObject;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/api/parking-spot")
public class ParkingSpotController {

    @Autowired //SERVICE INJECTION
    public ParkingSpotService PSservice;

    @PostMapping("/create")
    public ResponseEntity<Object> save(@RequestBody @Valid ParkingSpotDTO PSDTO){
        if(PSservice.existsBySpotNumber(PSDTO.getSpotNumber())){
            ResponseEntity.status(HttpStatus.CONFLICT).body("Conflict: spot number already taken.");
        }

        if(PSservice.existsByApartmentAndBlock(PSDTO.getApartment(), PSDTO.getBlock())){
            ResponseEntity.status(HttpStatus.CONFLICT).body("Conflict: apartment or block taken.");
        }

        var PSmodel = new ParkingSpotModel(); //novo model de parking spot | novo registo
        PSmodel.setRegistrationDate(LocalDateTime.now(ZoneId.of("UTC")));

        BeanUtils.copyProperties(PSDTO, PSmodel);
        return ResponseEntity.status(HttpStatus.CREATED).body(PSservice.save(PSmodel));
    }

    @GetMapping("/list") //GET ALL
    public ResponseEntity<List<ParkingSpotModel>> getAll() {
        return ResponseEntity.status(HttpStatus.OK).body(PSservice.getAll());
    }

    @GetMapping("/{id}") //GET BY ID
    public ResponseEntity<Object> getById(@PathVariable(value = "id") UUID id){
        Optional<ParkingSpotModel> dataFromDB = PSservice.getByID(id);

        if (!dataFromDB.isPresent()) {
            JSONObject msg = new JSONObject();
            msg.put("message","Not Found.");
            msg.put("status", HttpStatus.NOT_FOUND.value());
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(msg);
        }

        return ResponseEntity.status(HttpStatus.OK).body(dataFromDB);
    }


    @DeleteMapping("/delete/{id}") //DELETE BY ID
    public ResponseEntity<Object> delete(@PathVariable(value = "id") UUID id){
        Optional<ParkingSpotModel> dataToDelete = PSservice.getByID(id);

        if(!dataToDelete.isPresent()){
            JSONObject msg = new JSONObject();

            msg.put("message","Not Found.");
            msg.put("code",HttpStatus.NOT_FOUND.value());

            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(msg);
        }

        JSONObject msg = new JSONObject();
        try {
            PSservice.deleteByID(id);
            msg.put("message", "Deleted.");
            msg.put("code", HttpStatus.OK.value());
        } catch (Exception e){
            msg.put("message",e.getMessage());
            msg.put("code", HttpStatus.CONFLICT.value());
        }
        return ResponseEntity.status(HttpStatus.OK).body(msg);
    }
}
