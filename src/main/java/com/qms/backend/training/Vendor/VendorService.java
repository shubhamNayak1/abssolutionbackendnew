package com.qms.backend.training.Vendor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VendorService {

    @Autowired
    private VendorRepository vendorRepository;


    public List<Vendor> getAllVendor() {
        return vendorRepository.findAll();
    }

    public Vendor getVendorById(int id) {
        return vendorRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Vendor not found"));
    }

    public Vendor createVendor(Vendor userGroup) {
        return vendorRepository.save(userGroup);
    }

    public Vendor updateVendor(Vendor userGroup) {
        return vendorRepository.save(userGroup);
    }

    public void deleteVendor(int id) {
        vendorRepository.deleteById(id);
    }

}
