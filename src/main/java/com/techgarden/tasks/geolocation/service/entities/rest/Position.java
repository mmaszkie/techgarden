package com.techgarden.tasks.geolocation.service.entities.rest;

public class Position {

    private double longitude;

    private double latitude;

    public Position() {
    }

    public Position(double longitude, double latitude) {
        this.longitude = longitude;
        this.latitude = latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public double getLatitude() {
        return latitude;
    }
}