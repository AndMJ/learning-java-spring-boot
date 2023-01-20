package com.api.parkingcontrol.models;

import jakarta.persistence.*;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "TB-PARKING-SPOT")
public class ParkingSpotModel implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @Column(nullable = false, unique = true, length = 100)
    private String spotNumber;

    @Column(nullable = false, unique = true, length = 100)
    private String carLicensePlate;

    //TODO: JPA relations, create CAR MODEL and implement table relation
    @Column(nullable = false, length = 100)
    private String carBrand;

    @Column(nullable = false, length = 100)
    private String carModel;

    @Column(nullable = false, length = 100)
    private String carColor;

    @Column(nullable = false)
    private LocalDateTime registrationDate;

    @Column(nullable = false, length = 200)
    private String owner;

    @Column(nullable = false, length = 50)
    private String apartment;

    @Column(nullable = false, length = 50)
    private String block;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getSpotNumber() {
        return spotNumber;
    }

    public void setSpotNumber(String spotNumber) {
        this.spotNumber = spotNumber;
    }

    public String getCarLicensePlate() {
        return carLicensePlate;
    }

    public void setCarLicensePlate(String licensePlate) {
        this.carLicensePlate = licensePlate;
    }

    public String getCarBrand() {
        return carBrand;
    }

    public void setCarBrand(String carBrand) {
        this.carBrand = carBrand;
    }

    public String getCarModel() {
        return carModel;
    }

    public void setCarModel(String carModel) {
        this.carModel = carModel;
    }

    public String getCarColor() {
        return carColor;
    }

    public void setCarColor(String carColor) {
        this.carColor = carColor;
    }

    public LocalDateTime getRegistrationDate() {
        return registrationDate;
    }

    public void setRegistrationDate(LocalDateTime registrationDate) {
        this.registrationDate = registrationDate;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public String getApartment() {
        return apartment;
    }

    public void setApartment(String apartment) {
        this.apartment = apartment;
    }

    public String getBlock() {
        return block;
    }

    public void setBlock(String block) {
        this.block = block;
    }
}
