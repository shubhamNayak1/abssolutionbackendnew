package com.qms.backend.training.coordinator;

import com.qms.backend.user.User;
import com.qms.backend.user.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CoordinatorService {

    @Autowired
    private CoordinatorRepository coordinatorRepository;

    public CoordinatorResponseDTO createCoordinator(int userId, User user) {
        Coordinator coordinator = new Coordinator();
        coordinator.setUser(user);
        Coordinator savedCoordinator = coordinatorRepository.save(coordinator);
        return new CoordinatorResponseDTO(savedCoordinator.getUser().getId(), savedCoordinator.getUser().getUsername());
    }

    public List<CoordinatorResponseDTO> getAllCoordinators() {
        return coordinatorRepository.findAll().stream()
                .map(coordinator -> new CoordinatorResponseDTO(coordinator.getUser().getId(), coordinator.getUser().getUsername()))
                .collect(Collectors.toList());
    }

    public CoordinatorResponseDTO getCoordinator(int id) {
        Coordinator coordinator = coordinatorRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Coordinator not found with id: " + id));
        return new CoordinatorResponseDTO(coordinator.getUser().getId(), coordinator.getUser().getUsername());
    }

    public void deleteCoordinator(int id) {
        coordinatorRepository.deleteById(id);
    }
}
