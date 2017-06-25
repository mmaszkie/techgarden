package com.techgarden.tasks.geolocation.service.entities.rest;

public class Circle {

    private Position position;

    private double distance;

    public Circle() {}

    public Circle(Position position, double distance) {
        this.position = position;
        this.distance = distance;
    }

    public Position getPosition() {
        return position;
    }

    public double getDistance() {
        return distance;
    }
}