package com.techgarden.tasks.tree.model.elements;

import com.techgarden.tasks.tree.model.actions.Grow;

import java.util.HashSet;
import java.util.Set;

public abstract class Branch<Type> implements Grow {

    public Set<Leaf<Type>> leafs = new HashSet<>();

}
