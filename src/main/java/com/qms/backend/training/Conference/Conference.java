package com.qms.backend.training.Conference;

import com.qms.backend.training.Location.Location;
import jakarta.persistence.*;


@Entity
public class Conference {
    @Id
    private int id;
    private String name;
    private String address;
    private int seatingCapacity;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "location_id", nullable = false)
    private Location location;

    public Conference() {
    }

    public Conference(int id, String name, String address, int seatingCapacity, Location location) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.seatingCapacity = seatingCapacity;
        this.location = location;
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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getSeatingCapacity() {
        return seatingCapacity;
    }

    public void setSeatingCapacity(int seatingCapacity) {
        this.seatingCapacity = seatingCapacity;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    @Override
    public String toString() {
        return "name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", seatingCapacity=" + seatingCapacity +
                ", location=" + location ;
    }
}
