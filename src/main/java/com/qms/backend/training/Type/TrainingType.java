package com.qms.backend.training.Type;

import com.qms.backend.department.Department;
import com.qms.backend.training.Location.Location;
import jakarta.persistence.*;


@Entity
public class TrainingType {
    @Id
    private int id;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "department_id", nullable = false)
    private Department department;
    private String trainingType;
    private String trainingSubtype;
    private String name;



    public TrainingType() {
    }

    public TrainingType(int id, Department department, String trainingType, String trainingSubtype, String name) {
        this.id = id;
        this.department = department;
        this.trainingType = trainingType;
        this.trainingSubtype = trainingSubtype;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public String getTrainingType() {
        return trainingType;
    }

    public void setTrainingType(String trainingType) {
        this.trainingType = trainingType;
    }

    public String getTrainingSubtype() {
        return trainingSubtype;
    }

    public void setTrainingSubtype(String trainingSubtype) {
        this.trainingSubtype = trainingSubtype;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
