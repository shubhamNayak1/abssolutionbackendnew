package com.qms.backend.training.Conference;

public class ConferenceDTO {
    private int id;
    private String name;
    private String address;
    private int seatingCapacity;
    private int locationId;
    private String locationName;

    public ConferenceDTO() {
    }

    public ConferenceDTO(int id, String name, String address, int seatingCapacity, int locationId, String locationName) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.seatingCapacity = seatingCapacity;
        this.locationId = locationId;
        this.locationName = locationName;
    }

    public int getLocationId() {
        return locationId;
    }

    public void setLocationId(int locationId) {
        this.locationId = locationId;
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

    public String getLocationName() {
        return locationName;
    }

    public void setLocationName(String locationName) {
        this.locationName = locationName;
    }

    @Override
    public String toString() {
        return "name='" + name + '\'' +
                ", locationName='" + locationName + '\'' +
                ", address='" + address + '\'' +
                ", seatingCapacity=" + seatingCapacity ;
    }
}
