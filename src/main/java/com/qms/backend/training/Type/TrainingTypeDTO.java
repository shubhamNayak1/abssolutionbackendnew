package com.qms.backend.training.Type;

public class TrainingTypeDTO {
    private int id;
    private String trainingType;
    private String trainingSubtype;
    private String name;
    private int departmentId;
    private String departmentName;

    public TrainingTypeDTO() {
    }

    public TrainingTypeDTO(int id, String trainingType, String trainingSubtype, String name, int departmentId, String departmentName) {
        this.id = id;
        this.trainingType = trainingType;
        this.trainingSubtype = trainingSubtype;
        this.name = name;
        this.departmentId = departmentId;
        this.departmentName = departmentName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public int getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(int departmentId) {
        this.departmentId = departmentId;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }
}
