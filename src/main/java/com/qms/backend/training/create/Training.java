package com.qms.backend.training.create;

import java.util.Date;
import jakarta.persistence.*;

@Entity
@Table(name = "training")
public class Training {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "training_type_id", nullable = false)
    private Integer trainingTypeId;

    @Column(name = "location_id", nullable = false)
    private Integer locationId;

    @Column(name = "trainer_id", nullable = false)
    private Integer trainerId;

    @Column(name = "coordinator_id", nullable = false)
    private Integer coordinatorId;

    @Column(name = "training_materials")
    private Integer trainingMaterials;

    @Column(name = "exam")
    private Long exam;

    @Enumerated(EnumType.STRING)
    @Column(name = "frequency", nullable = false)
    private Frequency frequency;

    @Column(name = "`from`", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date from;

    @Column(name = "`to`", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date to;

    @Enumerated(EnumType.STRING)
    @Column(name = "status", nullable = false)
    private Status status;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getTrainingTypeId() {
        return trainingTypeId;
    }

    public void setTrainingTypeId(Integer trainingTypeId) {
        this.trainingTypeId = trainingTypeId;
    }

    public Integer getLocationId() {
        return locationId;
    }

    public void setLocationId(Integer locationId) {
        this.locationId = locationId;
    }

    public Integer getTrainerId() {
        return trainerId;
    }

    public void setTrainerId(Integer trainerId) {
        this.trainerId = trainerId;
    }

    public Integer getCoordinatorId() {
        return coordinatorId;
    }

    public void setCoordinatorId(Integer coordinatorId) {
        this.coordinatorId = coordinatorId;
    }

    public Integer getTrainingMaterials() {
        return trainingMaterials;
    }

    public void setTrainingMaterials(Integer trainingMaterials) {
        this.trainingMaterials = trainingMaterials;
    }

    public Long getExam() {
        return exam;
    }

    public void setExam(Long exam) {
        this.exam = exam;
    }

    public Frequency getFrequency() {
        return frequency;
    }

    public void setFrequency(Frequency frequency) {
        this.frequency = frequency;
    }

    public Date getFrom() {
        return from;
    }

    public void setFrom(Date from) {
        this.from = from;
    }

    public Date getTo() {
        return to;
    }

    public void setTo(Date to) {
        this.to = to;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public enum Frequency {
        One_time, Daily, Weekly, Monthly, Quarterly, Yearly
    }

    public enum Status {
        Created, Allocated, Training_Pending, Training_Complete, Attendance, Exam, Evaluated, Employee_Compliance, Compliance_Review, Reschedule
    }
}
