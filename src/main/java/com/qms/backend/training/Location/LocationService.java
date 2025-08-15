package com.qms.backend.training.Location;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LocationService {

    @Autowired
    private LocationRepository locationRepository;


    public List<Location> getAllLocation() {
        return locationRepository.findAll();
    }

    public Location getLocationById(int id) {
        return locationRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Location not found"));
    }

    public Location createLocation(Location userGroup) {
        return locationRepository.save(userGroup);
    }

    public Location updateLocation(Location userGroup) {
        return locationRepository.save(userGroup);
    }

    public void deleteLocation(int id) {
        locationRepository.deleteById(id);
    }

}
