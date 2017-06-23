package com.techgarden.tasks.tree.model.coniferous;

import com.techgarden.tasks.tree.model.parts.Branch;
import com.techgarden.tasks.tree.model.parts.Leaf;

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