package com.qms.backend.user;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

import java.util.ArrayList;
import java.util.Date;
import com.qms.backend.filters.DateModifier;
import jakarta.persistence.OneToMany;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Entity
public class User {
    @Id
    private int id;
    private String userId;
    private String username;
    private String firstName;
    private String lastName;
    private String password;
    private Date joiningDate;
    private String email;
    private String mobileNo;
    private String role;
    private Boolean intialPasswordChanged;

    // Default constructor
    public User() {
    }

    private String lastPassword1;
    private String lastPassword2;

    // Parameterized constructor
    public User(int id, String userId, String username, String firstName, String lastName, String password, Date joiningDate, String email, String mobileNo, String role) {
        this.id = id;
        this.userId = userId;
        this.username = username;
        this.firstName = firstName;
        this.lastName = lastName;
        this.password = password;
        this.joiningDate = joiningDate;
        this.email = email;
        this.mobileNo = mobileNo;
        this.role = role;
    }

    public String getLastPassword1() {
        return lastPassword1;
    }

    public void setLastPassword1(String lastPassword1) {
        this.lastPassword1 = lastPassword1;
    }

    public String getLastPassword2() {
        return lastPassword2;
    }

    public void setLastPassword2(String lastPassword2) {
        this.lastPassword2 = lastPassword2;
    }

    // Getters and Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String newPassword) {
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        this.lastPassword2 = this.lastPassword1;
        this.lastPassword1 = this.password;
        this.password = encoder.encode(newPassword);
    }

    public String getJoiningDate() {
        return DateModifier.formatToLocalDate(joiningDate);
    }

    public void setJoiningDate(Date joiningDate) {
        this.joiningDate = joiningDate;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMobileNo() {
        return mobileNo;
    }

    public void setMobileNo(String mobileNo) {
        this.mobileNo = mobileNo;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public Boolean getIntialPasswordChanged() {
        return intialPasswordChanged;
    }

    public void setIntialPasswordChanged(Boolean intialPasswordChanged) {
        this.intialPasswordChanged = intialPasswordChanged;
    }

    @Override
    public String toString() {
        return "userId='" + userId + '\'' +
                ", username='" + username + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", password='" + password + '\'' +
                ", joiningDate=" + joiningDate +
                ", email='" + email + '\'' +
                ", mobileNo='" + mobileNo + '\'';
    }
}
