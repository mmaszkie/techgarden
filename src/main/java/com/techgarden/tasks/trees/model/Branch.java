package com.techgarden.tasks.trees.model;

import java.util.HashSet;
import java.util.Set;

public abstract class Branch<Type> {

    protected Set<Leaf<Type>> leafs = new HashSet<>();

    public abstract Branch<Type> grow();

}
