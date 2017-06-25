package com.techgarden.tasks.tree.model.types.deciduous;

import com.techgarden.tasks.tree.model.elements.Branch;
import com.techgarden.tasks.tree.model.elements.Top;

public class DeciduousTop extends Top<Deciduous> {

    @Override
    public DeciduousTop grow() {
        height += 1.8;
        branches.add(new DeciduousBranch());
        for (Branch branch : branches) {
            branch.grow();
        }
        return this;
    }
}