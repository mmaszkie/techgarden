package com.techgarden.tasks.tree.model.elements;

import com.techgarden.tasks.tree.model.actions.Grow;

public abstract class Leaf<Type> implements Grow {

    public enum Color {

        GREEN,
        BROWN

    }

    public Color color;

    public double diameter;

}