package com.techgarden.tasks.trees.model;

public abstract class Tree<Type> {

    protected Trunk trunk;

    protected Top top;

    public Tree<Type> grow() {
        trunk.grow();
        top.grow();
        return this;
    }
}