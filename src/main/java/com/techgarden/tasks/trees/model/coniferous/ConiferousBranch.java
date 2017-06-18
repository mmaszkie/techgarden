package com.techgarden.tasks.trees.model.coniferous;

import com.techgarden.tasks.trees.model.Branch;
import com.techgarden.tasks.trees.model.Leaf;

public class ConiferousBranch extends Branch<Coniferous> {

    @Override
    public ConiferousBranch grow() {
        leafs.add(new ConiferousLeaf());
        leafs.add(new ConiferousLeaf());
        for (Leaf leaf : leafs) {
            leaf.grow();
        }
        return this;
    }
}