package com.qms.backend.training.Trainer;

import com.qms.backend.training.Vendor.Vendor;
import com.qms.backend.training.Vendor.VendorRepository;
import com.qms.backend.user.User;
import com.qms.backend.user.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TrainerService {
    @Autowired
    private TrainerRepository trainerRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private VendorRepository vendorRepository;

    public Trainer createTrainer(TrainerDto trainerDto) {
        Trainer trainer = new Trainer();
        trainer.setType(trainerDto.getType());

        if (trainerDto.getType() == TrainerType.internal) {
            User user = userRepository.findById(trainerDto.getUserId())
                    .orElseThrow(() -> new RuntimeException("User not found"));
            trainer.setUser(user);
            trainer.setMobileNo(user.getMobileNo());
            trainer.setEmailId(user.getEmail());
            trainer.setPersonName(user.getFirstName()+' '+user.getLastName());
            trainer.setVendor(null);
        } else {
            trainer.setPersonName(trainerDto.getPersonName());
            Vendor vendor = vendorRepository.findById(trainerDto.getVendorId())
                    .orElseThrow(() -> new RuntimeException("Vendor not found"));
            trainer.setVendor(vendor);
            trainer.setMobileNo(trainerDto.getMobileNo());
            trainer.setEmailId(trainerDto.getEmailId());
            trainer.setUser(null);
        }

        return trainerRepository.save(trainer);
    }

    public List<Trainer> getAllTrainers() {
        return trainerRepository.findAll();
    }

    public Optional<Trainer> getTrainerById(Integer id) {
        return trainerRepository.findById(id);
    }

    public Trainer updateTrainer(Integer id, TrainerDto trainerDto) {
        Trainer trainer = trainerRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Trainer not found"));

        trainer.setPersonName(trainerDto.getPersonName());
        trainer.setType(trainerDto.getType());

        if (trainerDto.getType() == TrainerType.internal) {
            User user = userRepository.findById(trainerDto.getUserId())
                    .orElseThrow(() -> new RuntimeException("User not found"));
            trainer.setUser(user);
            trainer.setMobileNo(user.getMobileNo());
            trainer.setEmailId(user.getEmail());
            trainer.setVendor(null);
        } else {
            Vendor vendor = vendorRepository.findById(trainerDto.getVendorId())
                    .orElseThrow(() -> new RuntimeException("Vendor not found"));
            trainer.setVendor(vendor);
            trainer.setMobileNo(trainerDto.getMobileNo());
            trainer.setEmailId(trainerDto.getEmailId());
            trainer.setUser(null);
        }

        return trainerRepository.save(trainer);
    }

    public void deleteTrainer(Integer id) {
        trainerRepository.deleteById(id);
    }
}
