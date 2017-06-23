package com.techgarden.tasks.tree.model.parts;

import java.util.HashSet;
import java.util.Set;

public abstract class Branch<Type> {

    public Set<Leaf<Type>> leafs = new HashSet<>();

    public abstract Branch<Type> grow();

}
