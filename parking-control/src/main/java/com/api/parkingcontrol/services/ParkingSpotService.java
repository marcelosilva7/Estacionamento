package com.api.parkingcontrol.services;

import com.api.parkingcontrol.models.ParkingSpotModel;
import com.api.parkingcontrol.repositories.ParkingSpotReository;
import jakarta.transaction.Transactional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.support.PageableExecutionUtils;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class ParkingSpotService {

    final
    ParkingSpotReository parkingSpotReository;

    public ParkingSpotService(ParkingSpotReository parkingSpotReository) {
        this.parkingSpotReository = parkingSpotReository;
    }

    @Transactional
    public ParkingSpotModel save(ParkingSpotModel parkingSpotModel) {
        return parkingSpotReository.save(parkingSpotModel);
    }

    public boolean existsByLicensePlateCar(String licensePlateCar) {
        return parkingSpotReository.existsByLicensePlateCar(licensePlateCar);
    }

    public boolean existsByParkingSpotNumber(String parkingSpotNumber) {
        return parkingSpotReository.existsByParkingSpotNumber(parkingSpotNumber);
    }

    public boolean existsByApartmentAndBlock(String apartment, String block) {
        return parkingSpotReository.existsByApartmentAndBlock(apartment, block);
    }

    public Page<ParkingSpotModel> findAll(Pageable pegeable) {
        return parkingSpotReository.findAll(pegeable);
    }
    /*
    public List<ParkingSpotModel> findAll() {
        return parkingSpotReository.findAll();
    }*/

    public Optional<ParkingSpotModel> findById(UUID id) {
        return parkingSpotReository.findById(id);
    }
    @Transactional
    public void delete(ParkingSpotModel parkingSpotModel) {
        parkingSpotReository.delete(parkingSpotModel);
    }
}
