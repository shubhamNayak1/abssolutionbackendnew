package com.qms.backend.training.Location;

import com.qms.backend.filters.StatusEnum;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;


@Entity
public class Location {
    @Id
    private int id;
    private String name;
    private StatusEnum status;

    // Default constructor
    public Location() {
    }

    // Parameterized constructor
    public Location(int id, String name,StatusEnum status) {
        this.id = id;
        this.name=name;
        this.status=status;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public StatusEnum getStatus() {
        return status;
    }

    public void setStatus(StatusEnum status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return  "id=" + id +
                ", name='" + name + '\'';
    }
}
