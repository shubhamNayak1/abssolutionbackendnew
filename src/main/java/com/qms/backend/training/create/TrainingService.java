package com.qms.backend.training.create;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TrainingService {

    @Autowired
    private TrainingRepository trainingRepository;

    public List<Training> getAllTrainings() {
        return trainingRepository.findAll();
    }

    public Optional<Training> getTrainingById(Integer id) {
        return trainingRepository.findById(id);
    }

    public Training saveTraining(Training training) {
        return trainingRepository.save(training);
    }

    public void deleteTraining(Integer id) {
        trainingRepository.deleteById(id);
    }
}