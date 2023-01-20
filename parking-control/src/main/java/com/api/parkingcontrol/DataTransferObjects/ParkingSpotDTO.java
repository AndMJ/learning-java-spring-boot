package com.api.parkingcontrol.DataTransferObjects;

import jakarta.validation.constraints.NotBlank;


public class ParkingSpotDTO {
    @NotBlank
    private String spotNumber;
    @NotBlank
    private String carLicensePlate;
    @NotBlank
    private String carBrand;
    @NotBlank
    private String carModel;
    @NotBlank
    private String carColor;
    //private LocalDateTime registrationDate;
    @NotBlank
    private String owner;
    @NotBlank
    private String apartment;
    @NotBlank
    private String block;
}
