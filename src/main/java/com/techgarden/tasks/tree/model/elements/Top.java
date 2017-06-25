package com.techgarden.tasks.tree.model.elements;

import com.techgarden.tasks.tree.model.actions.Grow;

import java.util.HashSet;
import java.util.Set;

public abstract class Top<Type> implements Grow {

    public double height;

    public Set<Branch<Type>> branches = new HashSet<>();

}