package com.techgarden.tasks.tree.model.coniferous;

import com.techgarden.tasks.tree.model.parts.Branch;
import com.techgarden.tasks.tree.model.parts.Top;

public class ConiferousTop extends Top<Coniferous> {

    @Override
    public ConiferousTop grow() {
        height += 0.8;
        branches.add(new ConiferousBranch());
        for (Branch branch : branches) {
            branch.grow();
        }
        return this;
    }
}