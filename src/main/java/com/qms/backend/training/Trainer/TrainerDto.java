package com.qms.backend.training.Trainer;

public class TrainerDto {
    private Integer vendorId;
    private Integer userId;
    private String personName;
    private String mobileNo;
    private String emailId;
    private TrainerType type;

    public TrainerDto() {
    }

    public TrainerDto(Integer vendorId, Integer userId, String personName, String mobileNo, String emailId, TrainerType type) {
        this.vendorId = vendorId;
        this.userId = userId;
        this.personName = personName;
        this.mobileNo = mobileNo;
        this.emailId = emailId;
        this.type = type;
    }

    public Integer getVendorId() {
        return vendorId;
    }

    public void setVendorId(Integer vendorId) {
        this.vendorId = vendorId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getPersonName() {
        return personName;
    }

    public void setPersonName(String personName) {
        this.personName = personName;
    }

    public String getMobileNo() {
        return mobileNo;
    }

    public void setMobileNo(String mobileNo) {
        this.mobileNo = mobileNo;
    }

    public String getEmailId() {
        return emailId;
    }

    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }

    public TrainerType getType() {
        return type;
    }

    public void setType(TrainerType type) {
        this.type = type;
    }
}
