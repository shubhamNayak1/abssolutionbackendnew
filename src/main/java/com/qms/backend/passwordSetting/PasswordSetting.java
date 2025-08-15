package com.qms.backend.passwordSetting;

import com.qms.backend.filters.DateModifier;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

import java.util.Date;

@Entity
public class PasswordSetting {

    @Id
    private int id;
    private int passwordLengthMin;
    private int passwordLengthMax;
    private int alphaMin;
    private int numericMin;
    private int specialCharMin;
    private int upperCaseMin;
    private int numberOfLoginAttempts;
    private int validPeriod;
    private int previousPasswordAttemptTrack;
    private Date effectiveDate;

    // Default constructor
    public PasswordSetting() {
    }

    public PasswordSetting(int id, int passwordLengthMin, int passwordLengthMax, int alphaMin, int numericMin, int specialCharMin, int upperCaseMin, int numberOfLoginAttempts, int validPeriod, int previousPasswordAttemptTrack, Date effectiveDate) {
        this.id = id;
        this.passwordLengthMin = passwordLengthMin;
        this.passwordLengthMax = passwordLengthMax;
        this.alphaMin = alphaMin;
        this.numericMin = numericMin;
        this.specialCharMin = specialCharMin;
        this.upperCaseMin = upperCaseMin;
        this.numberOfLoginAttempts = numberOfLoginAttempts;
        this.validPeriod = validPeriod;
        this.previousPasswordAttemptTrack = previousPasswordAttemptTrack;
        this.effectiveDate = effectiveDate;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPasswordLengthMin() {
        return passwordLengthMin;
    }

    public void setPasswordLengthMin(int passwordLengthMin) {
        this.passwordLengthMin = passwordLengthMin;
    }

    public int getPasswordLengthMax() {
        return passwordLengthMax;
    }

    public void setPasswordLengthMax(int passwordLengthMax) {
        this.passwordLengthMax = passwordLengthMax;
    }

    public int getAlphaMin() {
        return alphaMin;
    }

    public void setAlphaMin(int alphaMin) {
        this.alphaMin = alphaMin;
    }

    public int getNumericMin() {
        return numericMin;
    }

    public void setNumericMin(int numericMin) {
        this.numericMin = numericMin;
    }

    public int getSpecialCharMin() {
        return specialCharMin;
    }

    public void setSpecialCharMin(int specialCharMin) {
        this.specialCharMin = specialCharMin;
    }

    public int getUpperCaseMin() {
        return upperCaseMin;
    }

    public void setUpperCaseMin(int upperCaseMin) {
        this.upperCaseMin = upperCaseMin;
    }

    public int getNumberOfLoginAttempts() {
        return numberOfLoginAttempts;
    }

    public void setNumberOfLoginAttempts(int numberOfLoginAttempts) {
        this.numberOfLoginAttempts = numberOfLoginAttempts;
    }

    public int getValidPeriod() {
        return validPeriod;
    }

    public void setValidPeriod(int validPeriod) {
        this.validPeriod = validPeriod;
    }

    public int getPreviousPasswordAttemptTrack() {
        return previousPasswordAttemptTrack;
    }

    public void setPreviousPasswordAttemptTrack(int previousPasswordAttemptTrack) {
        this.previousPasswordAttemptTrack = previousPasswordAttemptTrack;
    }

    public String getEffectiveDate() {
        return DateModifier.formatToLocalDate(effectiveDate);
    }

    public void setEffectiveDate(Date effectiveDate) {
        this.effectiveDate = effectiveDate;
    }

    @Override
    public String toString() {
        return  "passwordLengthMin=" + passwordLengthMin +
                ", passwordLengthMax=" + passwordLengthMax +
                ", alphaMin=" + alphaMin +
                ", numericMin=" + numericMin +
                ", specialCharMin=" + specialCharMin +
                ", upperCaseMin=" + upperCaseMin +
                ", numberOfLoginAttempts=" + numberOfLoginAttempts +
                ", validPeriod=" + validPeriod +
                ", previousPasswordAttemptTrack=" + previousPasswordAttemptTrack +
                ", effectiveDate=" + effectiveDate ;
    }
}
