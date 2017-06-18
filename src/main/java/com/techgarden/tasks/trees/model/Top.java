package com.techgarden.tasks.trees.model;

import java.util.HashSet;
import java.util.Set;

public abstract class Top<Type> {

    protected Set<Branch<Type>> branches = new HashSet<>();

    protected abstract Top<Type> grow();

}