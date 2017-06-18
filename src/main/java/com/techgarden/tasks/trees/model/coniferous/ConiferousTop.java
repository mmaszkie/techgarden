package com.techgarden.tasks.trees.model.coniferous;

import com.techgarden.tasks.trees.model.Branch;
import com.techgarden.tasks.trees.model.Top;

public class ConiferousTop extends Top<Coniferous> {

    @Override
    public ConiferousTop grow() {
        branches.add(new ConiferousBranch());
        for (Branch branch : branches) {
            branch.grow();
        }
        return this;
    }
}