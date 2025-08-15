package com.qms.backend.training.coordinator;

public class CoordinatorResponseDTO {
    private int userId;
    private String username;

    // Constructor
    public CoordinatorResponseDTO(int userId, String username) {
        this.userId = userId;
        this.username = username;
    }

    // Getters and Setters
    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}

