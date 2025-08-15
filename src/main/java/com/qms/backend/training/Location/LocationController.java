package com.qms.backend.training.Location;

import com.qms.backend.userActivity.UserActivityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/training/location")
public class LocationController {

    @Autowired
    private LocationService locationService;

    @Autowired
    private UserActivityService userActivityService;

    @GetMapping
    public ResponseEntity<List<Location>> getAllLocation() {
        List<Location> department = locationService.getAllLocation();
        return new ResponseEntity<>(department, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Location> getLocationById(@PathVariable int id) {
        Location location = locationService.getLocationById(id);
        return new ResponseEntity<>(location, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Location> createLocation(@RequestBody Location location) {
        Location createdLocation = locationService.createLocation(location);
        String newData = createdLocation.toString();

        userActivityService.createUserActivity(
                "user123",
                "-",
                "-",
                newData,
                "/api/Location",
                "Location created"
        );
        return new ResponseEntity<>(createdLocation, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Location> updateLocation(@PathVariable int id, @RequestBody Location location) {
        location.setId(id);
        Location oldLocation = locationService.getLocationById(id);
        String oldData = oldLocation.toString();
        Location updatedLocation = locationService.updateLocation(location);
        String newData = updatedLocation.toString();
        userActivityService.createUserActivity(
                "user123",
                "-",
                oldData,
                newData,
                "/api/location",
                "Location created"
        );
        return new ResponseEntity<>(updatedLocation, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteLocation(@PathVariable int id) {
        locationService.deleteLocation(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}