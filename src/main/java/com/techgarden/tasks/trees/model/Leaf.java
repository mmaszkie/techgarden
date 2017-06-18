package com.techgarden.tasks.trees.model;

public abstract class Leaf<Type> {

    public enum Color {

        GREEN,
        BROWN,
        RED,
        YELLOW

    }

    protected Color color;

    protected double diameter;

    public abstract Leaf<Type> grow();

}