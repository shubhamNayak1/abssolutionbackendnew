package com.qms.backend.department;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;


@Entity
public class Department {
    @Id
    private int id;
    private String departmentName;
    private String departmentShortCode;


    // Default constructor
    public Department() {
    }

    // Parameterized constructor
    public Department(int id, String departmentName, String departmentShortCode ) {
        this.id = id;
        this.departmentName=departmentName;
        this.departmentShortCode=departmentShortCode;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    public String getDepartmentShortCode() {
        return departmentShortCode;
    }

    public void setDepartmentShortCode(String departmentShortCode) {
        this.departmentShortCode = departmentShortCode;
    }

    @Override
    public String toString() {
        return "departmentName='" + departmentName + '\'' +
                ", departmentShortCode='" + departmentShortCode + '\'';
    }
}
