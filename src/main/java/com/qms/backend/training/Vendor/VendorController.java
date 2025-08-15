package com.qms.backend.training.Vendor;

import com.qms.backend.userActivity.UserActivityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/training/vendor")
public class VendorController {

    @Autowired
    private VendorService vendorService;

    @Autowired
    private UserActivityService userActivityService;

    @GetMapping
    public ResponseEntity<List<Vendor>> getAllVendor() {
        List<Vendor> department = vendorService.getAllVendor();
        return new ResponseEntity<>(department, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Vendor> getVendorById(@PathVariable int id) {
        Vendor Vendor = vendorService.getVendorById(id);
        return new ResponseEntity<>(Vendor, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Vendor> createVendor(@RequestBody Vendor Vendor) {
        Vendor createdVendor = vendorService.createVendor(Vendor);
        String newData = createdVendor.toString();

        userActivityService.createUserActivity(
                "user123",
                "-",
                "-",
                newData,
                "/api/Vendor",
                "Vendor created"
        );
        return new ResponseEntity<>(createdVendor, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Vendor> updateVendor(@PathVariable int id, @RequestBody Vendor Vendor) {
        Vendor.setId(id);
        Vendor oldVendor = vendorService.getVendorById(id);
        String oldData = oldVendor.toString();
        Vendor updatedVendor = vendorService.updateVendor(Vendor);
        String newData = updatedVendor.toString();
        userActivityService.createUserActivity(
                "user123",
                "-",
                oldData,
                newData,
                "/api/Vendor",
                "Vendor created"
        );
        return new ResponseEntity<>(updatedVendor, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteVendor(@PathVariable int id) {
        vendorService.deleteVendor(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}