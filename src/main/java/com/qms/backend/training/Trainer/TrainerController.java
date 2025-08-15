package com.qms.backend.training.Trainer;

import com.qms.backend.training.Conference.ConferenceDTO;
import com.qms.backend.training.Conference.ConferenceService;
import com.qms.backend.userActivity.UserActivityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/training/trainers")
public class TrainerController {

    @Autowired
    private TrainerService trainerService;

    @Autowired
    private UserActivityService userActivityService;

    @PostMapping
    public ResponseEntity<Trainer> createTrainer(@RequestBody TrainerDto trainerDto) {
        Trainer trainer = trainerService.createTrainer(trainerDto);
        return ResponseEntity.ok(trainer);
    }

    @GetMapping
    public ResponseEntity<List<Trainer>> getAllTrainers() {
        List<Trainer> trainers = trainerService.getAllTrainers();
        return ResponseEntity.ok(trainers);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Trainer> getTrainerById(@PathVariable Integer id) {
        Trainer trainer = trainerService.getTrainerById(id)
                .orElseThrow(() -> new RuntimeException("Trainer not found"));
        return ResponseEntity.ok(trainer);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Trainer> updateTrainer(@PathVariable Integer id, @RequestBody TrainerDto trainerDto) {
        Trainer trainer = trainerService.updateTrainer(id, trainerDto);
        return ResponseEntity.ok(trainer);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTrainer(@PathVariable Integer id) {
        trainerService.deleteTrainer(id);
        return ResponseEntity.noContent().build();
    }
}