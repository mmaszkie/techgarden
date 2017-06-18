package com.techgarden.tasks.trees.model.deciduous;

import com.techgarden.tasks.trees.model.Branch;
import com.techgarden.tasks.trees.model.Top;

public class DeciduousTop extends Top<Deciduous> {

    @Override
    protected DeciduousTop grow() {
        branches.add(new DeciduousBranch());
        for (Branch branch : branches) {
            branch.grow();
        }
        return this;
    }
}