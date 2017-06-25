package com.techgarden.tasks.geolocation.service.entities.rest;

public class Geolocation {

    private String name;

    private Position position;

    public Geolocation() {}

    public Geolocation(String name, Position position) {
        this.name = name;
        this.position = position;
    }

    public String getName() {
        return name;
    }

    public Position getPosition() {
        return position;
    }
}