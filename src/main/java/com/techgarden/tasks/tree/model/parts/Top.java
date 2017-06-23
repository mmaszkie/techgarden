package com.techgarden.tasks.tree.model.parts;

import java.util.HashSet;
import java.util.Set;

public abstract class Top<Type> {

    public double height;

    public Set<Branch<Type>> branches = new HashSet<>();

    public abstract Top<Type> grow();

}