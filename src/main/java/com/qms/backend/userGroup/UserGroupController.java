package com.qms.backend.userGroup;

import com.qms.backend.userActivity.UserActivityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/user/group")
public class UserGroupController {

    @Autowired
    private UserGroupService userGroupService;

    @Autowired
    private UserActivityService userActivityService;

    @GetMapping
    public ResponseEntity<List<UserGroup>> getAllUsersGroup() {
        List<UserGroup> usersGroup = userGroupService.getAllUsersGroup();
        return new ResponseEntity<>(usersGroup, HttpStatus.OK);
    }

    @GetMapping("/count")
    public ResponseEntity<Number> getUserFGroupTotalCount() {
        Number count = userGroupService.getTotalCountUserGroup();
        return new ResponseEntity<>(count, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserGroup> getUserGroupById(@PathVariable int id) {
        UserGroup usersGroup = userGroupService.getUserGroupById(id);
        return new ResponseEntity<>(usersGroup, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<UserGroup> createUserGroup(@RequestBody UserGroup userGroup) {
        UserGroup createdUserGroup = userGroupService.createUserGroup(userGroup);
        String newData = createdUserGroup.toString();

        userActivityService.createUserActivity(
                "user123",
                "-",
                "-",
                newData,
                "/api/department",
                "Department created"
        );

        return new ResponseEntity<>(createdUserGroup, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<UserGroup> updateUserGroup(@PathVariable int id, @RequestBody UserGroup userGroup) {
        userGroup.setId(id);
        UserGroup updatedUser = userGroupService.updateUserGroup(userGroup);
        return new ResponseEntity<>(updatedUser, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUserGroup(@PathVariable int id) {
        userGroupService.deleteUserGroup(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}