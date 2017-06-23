package com.techgarden.tasks.tree.model;

import com.techgarden.tasks.tree.model.parts.Top;
import com.techgarden.tasks.tree.model.parts.Trunk;

public abstract class Tree<Type> {

    protected Trunk trunk;

    protected Top top;

    public Tree<Type> grow() {
        trunk.grow();
        top.grow();
        return this;
    }

    public double getHeight() {
        return trunk.height + top.height;
    }
}