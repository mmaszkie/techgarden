package com.techgarden.tasks.tree.model.types.coniferous;

import com.techgarden.tasks.tree.model.elements.Branch;
import com.techgarden.tasks.tree.model.elements.Leaf;

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