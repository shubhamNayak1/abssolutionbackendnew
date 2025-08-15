package com.qms.backend.passwordSetting;

import com.qms.backend.userActivity.UserActivityService;
import com.qms.backend.userGroup.UserGroup;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/password")
public class PasswordSettingController {

    @Autowired
    private PasswordSettingService passwordSettingService;

    @Autowired
    private UserActivityService userActivityService;

    @GetMapping
    public ResponseEntity<List<PasswordSetting>> getAllUsersGroup() {
        List<PasswordSetting> passwordSettings = passwordSettingService.getAllPasswordSetting();
        return new ResponseEntity<>(passwordSettings, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<PasswordSetting> getPasswordById(@PathVariable int id) {
        PasswordSetting user = passwordSettingService.getPasswordSettingById(id);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<PasswordSetting> createPassword(@RequestBody PasswordSetting passwordSetting) {
        PasswordSetting createdPassword = passwordSettingService.createpasswordSetting(passwordSetting);

        String newData = createdPassword.toString();

        userActivityService.createUserActivity(
                "user123",
                "-",
                "-",
                newData,
                "/api/password",
                "Password created"
        );


        return new ResponseEntity<>(createdPassword, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<PasswordSetting> updatePassword(@PathVariable int id, @RequestBody PasswordSetting passwordSetting) {

        PasswordSetting existingPassSetting = passwordSettingService.getPasswordSettingById(id);
        String oldData = existingPassSetting.toString();

        passwordSetting.setId(id);
        PasswordSetting updatedPassSetting = passwordSettingService.updatePasswordSetting(passwordSetting);


        String newData = updatedPassSetting.toString();

        userActivityService.createUserActivity(
                "user123",
                "-",
                oldData,
                newData,
                "/api/password",
                "Password Updated"
        );

        return new ResponseEntity<>(updatedPassSetting, HttpStatus.OK);
    }

}