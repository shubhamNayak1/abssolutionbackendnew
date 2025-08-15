package com.qms.backend.userActivity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@Service
public class UserActivityService {

    @Autowired
    private UserActivityRepository userActivityRepository;

    public List<UserActivity> getAllUserActivity() {
        return userActivityRepository.findAll();
    }

    public void createUserActivity(String username, String location, String oldData, String newData, String details, String remark) {
        UserActivity userActivity = new UserActivity();
        userActivity.setActivityDate(LocalDate.now());
        userActivity.setActivityTime(LocalTime.now());
        userActivity.setUsername(username);
        userActivity.setLocation(location);
        userActivity.setOldData(oldData);
        userActivity.setNewData(newData);
        userActivity.setDetails(details);
        userActivity.setRemark(remark);
        userActivityRepository.save(userActivity);
    }



}
