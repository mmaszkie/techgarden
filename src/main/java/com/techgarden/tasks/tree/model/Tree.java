package com.techgarden.tasks.tree.model;

import com.techgarden.tasks.tree.model.actions.Grow;
import com.techgarden.tasks.tree.model.elements.Top;
import com.techgarden.tasks.tree.model.elements.Trunk;

public abstract class Tree<Type> implements Grow<Tree<Type>> {

    protected Trunk trunk;

    protected Top top;

    @Override
    public Tree<Type> grow() {
        trunk.grow();
        top.grow();
        return this;
    }

    double getHeight() {
        return trunk.height + top.height;
    }
}