package com.qms.backend.userGroup;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserGroupService {

    @Autowired
    private UserGroupRepository userGroupRepository;

    public Number getTotalCountUserGroup() {
        return userGroupRepository.count();
    }

    public List<UserGroup> getAllUsersGroup() {
        return userGroupRepository.findAll();
    }

    public UserGroup getUserGroupById(int id) {
        return userGroupRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("User Group not found"));
    }

    public UserGroup createUserGroup(UserGroup userGroup) {
        return userGroupRepository.save(userGroup);
    }

    public UserGroup updateUserGroup(UserGroup userGroup) {
        return userGroupRepository.save(userGroup);
    }

    public void deleteUserGroup(int id) {
        userGroupRepository.deleteById(id);
    }

}
