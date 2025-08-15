package com.qms.backend.training.coordinator;

import com.qms.backend.user.User;
import com.qms.backend.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/coordinators")
public class CoordinatorController {
    @Autowired
    private CoordinatorService coordinatorService;

    @Autowired
    private UserService userService;

    @PostMapping
    public ResponseEntity<CoordinatorResponseDTO> createCoordinator(@RequestParam int userId) {
        // Assuming User object is retrieved by userId from a UserService
        User user = userService.getUserById(userId);
        CoordinatorResponseDTO coordinator = coordinatorService.createCoordinator(userId, user);
        return ResponseEntity.ok(coordinator);
    }

    @GetMapping
    public ResponseEntity<List<CoordinatorResponseDTO>> getAllCoordinators() {
        List<CoordinatorResponseDTO> coordinators = coordinatorService.getAllCoordinators();
        return ResponseEntity.ok(coordinators);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CoordinatorResponseDTO> getCoordinator(@PathVariable int id) {
        CoordinatorResponseDTO coordinator = coordinatorService.getCoordinator(id);
        return ResponseEntity.ok(coordinator);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCoordinator(@PathVariable int id) {
        coordinatorService.deleteCoordinator(id);
        return ResponseEntity.noContent().build();
    }
}