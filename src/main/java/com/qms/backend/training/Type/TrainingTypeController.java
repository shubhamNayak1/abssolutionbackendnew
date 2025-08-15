package com.qms.backend.training.Type;

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
@RequestMapping("/api/training/type")
public class TrainingTypeController {

    @Autowired
    private TrainingTypeService trainingTypeService;

    @Autowired
    private UserActivityService userActivityService;

    @GetMapping
    public ResponseEntity<List<TrainingTypeDTO>> getAllTrainingType() {
        List<TrainingTypeDTO> trainingTypeDTO = trainingTypeService.getAllTrainingType();
        return new ResponseEntity<>(trainingTypeDTO, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<TrainingTypeDTO> getTrainingTypeById(@PathVariable int id) {
        TrainingTypeDTO trainingTypeDTO = trainingTypeService.getTrainingTypeById(id);
        return new ResponseEntity<>(trainingTypeDTO, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<TrainingTypeDTO> createTrainingType(@RequestBody TrainingTypeDTO trainingType) {
        TrainingTypeDTO trainingTypeDTO = trainingTypeService.createTrainingType(trainingType);
        return new ResponseEntity<>(trainingTypeDTO, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<TrainingTypeDTO> updateTrainingType(@PathVariable int id, @RequestBody TrainingTypeDTO trainingTypeDTO) {
        TrainingTypeDTO updatedTrainingType = trainingTypeService.updateTrainingType(id, trainingTypeDTO);
        return new ResponseEntity<>(updatedTrainingType, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTrainingType(@PathVariable int id) {
        trainingTypeService.deleteTrainingType(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}