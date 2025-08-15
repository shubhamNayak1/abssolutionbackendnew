package com.qms.backend.training.Type;

import com.qms.backend.department.Department;
import com.qms.backend.department.DepartmentRepository;
import com.qms.backend.training.Conference.Conference;
import com.qms.backend.training.Conference.ConferenceDTO;
import com.qms.backend.training.Conference.ConferenceRepository;
import com.qms.backend.training.Location.Location;
import com.qms.backend.training.Location.LocationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TrainingTypeService {

    @Autowired
    private TrainingTypeRepository trainingTypeRepository;

    @Autowired
    private DepartmentRepository departmentRepository;

    public List<TrainingTypeDTO> getAllTrainingType() {
        List<TrainingType> trainingTypes = trainingTypeRepository.findAllWithDepartmentName();
        return trainingTypes.stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    public TrainingTypeDTO getTrainingTypeById(int id) {
        TrainingType trainingType = trainingTypeRepository.findByIdWithDepartmentName(id)
                .orElseThrow(() -> new RuntimeException("TrainingType not found with id " + id));
        return convertToDTO(trainingType);
    }

    public TrainingTypeDTO createTrainingType(TrainingTypeDTO trainingTypeDTO) {
        TrainingType trainingType = new TrainingType();
        mapDtoToEntity(trainingTypeDTO, trainingType);
        TrainingType savedTrainingType = trainingTypeRepository.save(trainingType);
        return convertToDTO(savedTrainingType);
    }

    public TrainingTypeDTO updateTrainingType(int id, TrainingTypeDTO trainingTypeDTO) {
        TrainingType trainingType = trainingTypeRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Training Type not found with id " + id));
        mapDtoToEntity(trainingTypeDTO, trainingType);
        TrainingType updatedTrainingType = trainingTypeRepository.save(trainingType);
        return convertToDTO(updatedTrainingType);
    }

    public void deleteTrainingType(int id) {
        TrainingType trainingType  = trainingTypeRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Training Type not found with id " + id));
        trainingTypeRepository.delete(trainingType);
    }

    private void mapDtoToEntity(TrainingTypeDTO trainingTypeDTO, TrainingType trainingType) {
        trainingType.setName(trainingTypeDTO.getName());
        trainingType.setTrainingType(trainingTypeDTO.getTrainingType());
        trainingType.setTrainingSubtype(trainingTypeDTO.getTrainingSubtype());
        Department department = departmentRepository.findById(trainingTypeDTO.getDepartmentId())
                .orElseThrow(() -> new RuntimeException("Department not found with id " + trainingTypeDTO.getDepartmentId()));
        trainingType.setDepartment(department);
    }

    private TrainingTypeDTO convertToDTO(TrainingType trainingType) {
        TrainingTypeDTO dto = new TrainingTypeDTO();
        dto.setId(trainingType.getId());
        dto.setName(trainingType.getName());
        dto.setTrainingType(trainingType.getTrainingType());
        dto.setTrainingSubtype(trainingType.getTrainingSubtype());
        dto.setDepartmentId(trainingType.getDepartment().getId());
        dto.setDepartmentName(trainingType.getDepartment().getDepartmentName());
        return dto;
    }
}
