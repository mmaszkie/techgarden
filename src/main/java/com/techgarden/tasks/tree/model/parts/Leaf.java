package com.techgarden.tasks.tree.model.parts;

public abstract class Leaf<Type> {

    public enum Color {

        GREEN,
        BROWN

    }

    public Color color;

    public double diameter;

    public abstract Leaf<Type> grow();

}