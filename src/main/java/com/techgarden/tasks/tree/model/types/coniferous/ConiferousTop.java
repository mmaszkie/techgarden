package com.techgarden.tasks.tree.model.types.coniferous;

import com.techgarden.tasks.tree.model.elements.Branch;
import com.techgarden.tasks.tree.model.elements.Top;

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