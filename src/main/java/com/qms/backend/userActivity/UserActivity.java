package com.qms.backend.userActivity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.time.LocalDate;
import java.time.LocalTime;


@Entity
public class UserActivity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long activityId;

    private LocalDate activityDate;

    private LocalTime activityTime;

    private String username;

    private String location;

    private String oldData;

    private String newData;

    private String details;

    private String remark;

    // Default constructor
    public UserActivity() {
    }

    // Parameterized constructor
    public UserActivity(Long activityId, LocalDate activityDate, LocalTime activityTime, String username, String location, String oldData, String newData, String details, String remark) {
        this.activityId = activityId;
        this.activityDate = activityDate;
        this.activityTime = activityTime;
        this.username = username;
        this.location = location;
        this.oldData = oldData;
        this.newData = newData;
        this.details = details;
        this.remark = remark;
    }

    public Long getActivityId() {
        return activityId;
    }

    public void setActivityId(Long activityId) {
        this.activityId = activityId;
    }

    public LocalDate getActivityDate() {
        return activityDate;
    }

    public void setActivityDate(LocalDate activityDate) {
        this.activityDate = activityDate;
    }

    public LocalTime getActivityTime() {
        return activityTime;
    }

    public void setActivityTime(LocalTime activityTime) {
        this.activityTime = activityTime;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getOldData() {
        return oldData;
    }

    public void setOldData(String oldData) {
        this.oldData = oldData;
    }

    public String getNewData() {
        return newData;
    }

    public void setNewData(String newData) {
        this.newData = newData;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }
}
