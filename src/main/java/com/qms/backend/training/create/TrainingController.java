package com.qms.backend.training.create;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/trainings")
public class TrainingController {

    @Autowired
    private TrainingService trainingService;

    @GetMapping
    public List<Training> getAllTrainings() {
        return trainingService.getAllTrainings();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Training> getTrainingById(@PathVariable Integer id) {
        Optional<Training> training = trainingService.getTrainingById(id);
        return training.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public Training createTraining(@RequestBody Training training) {
        return trainingService.saveTraining(training);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Training> updateTraining(@PathVariable Integer id, @RequestBody Training training) {
        if (!trainingService.getTrainingById(id).isPresent()) {
            return ResponseEntity.notFound().build();
        }
        training.setId(id);
        return ResponseEntity.ok(trainingService.saveTraining(training));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTraining(@PathVariable Integer id) {
        if (!trainingService.getTrainingById(id).isPresent()) {
            return ResponseEntity.notFound().build();
        }
        trainingService.deleteTraining(id);
        return ResponseEntity.noContent().build();
    }
}