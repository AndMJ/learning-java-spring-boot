package com.api.parkingcontrol.repositories;

import com.api.parkingcontrol.models.ParkingSpotModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface ParkingSpotRepo extends JpaRepository</*model*/ ParkingSpotModel, /*identifier type*/ UUID> {
    /*
    * jpaRepo has methods for DB transactions
    * but custom ones can be implemented
    * TODO: see how to create one transaction method
    * */
}
