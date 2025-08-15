package com.qms.backend.training.Trainer;

import com.qms.backend.training.Vendor.Vendor;
import com.qms.backend.user.User;
import jakarta.persistence.*;


@Entity
public class Trainer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "vendor_id", nullable = true)
    private Vendor vendor;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = true)
    private User user;

    @Column(name = "person_name", nullable = false)
    private String personName;

    @Column(name = "mobile_no", nullable = false)
    private String mobileNo;

    @Column(name = "email_id", nullable = false)
    private String emailId;

    @Enumerated(EnumType.STRING)
    @Column(name = "type", nullable = false)
    private TrainerType type;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Vendor getVendor() {
        return vendor;
    }

    public void setVendor(Vendor vendor) {
        this.vendor = vendor;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
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

enum TrainerType {
    internal, external
}
