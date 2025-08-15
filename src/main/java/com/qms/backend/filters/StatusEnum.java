package com.qms.backend.filters;

public enum StatusEnum {

    Active(0),
    Deactivate(-1);

    private final int value;

    // Constructor
    StatusEnum(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
