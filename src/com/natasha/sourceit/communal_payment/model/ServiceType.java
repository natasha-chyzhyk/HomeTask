package com.natasha.sourceit.communal_payment.model;


public enum ServiceType {
    INTERNET("Internet service"), PHONE("Wired Telephone");

    private String readableName;
    private ServiceType(String readableName) {
        this.readableName = readableName;
    }

    public String getReadableName() {
        return readableName;
    }

    @Override
    public String toString() {
        return readableName;
    }
}
