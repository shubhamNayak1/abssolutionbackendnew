package com.qms.backend.userGroup;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;


@Entity
public class UserGroup {
    @Id
    private int id;
    private String groupName;
    private String groupDescription;


    // Default constructor
    public UserGroup() {
    }

    // Parameterized constructor
    public UserGroup(int id, String groupName,String groupDescription ) {
        this.id = id;
        this.groupName=groupName;
        this.groupDescription=groupDescription;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    public String getGroupDescription() {
        return groupDescription;
    }

    public void setGroupDescription(String groupDescription) {
        this.groupDescription = groupDescription;
    }

    @Override
    public String toString() {
        return "groupName='" + groupName + '\'' +
                ", groupDescription='" + groupDescription + '\'';
    }
}
