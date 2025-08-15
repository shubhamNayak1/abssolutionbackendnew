package com.qms.backend.userActivity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/user/activity")
public class UserActivityController {

    @Autowired
    private UserActivityService userActivityService;

    @GetMapping
    public ResponseEntity<List<UserActivity>> getAllUserActivity() {
        List<UserActivity> usersGroup = userActivityService.getAllUserActivity();
        return new ResponseEntity<>(usersGroup, HttpStatus.OK);
    }
}