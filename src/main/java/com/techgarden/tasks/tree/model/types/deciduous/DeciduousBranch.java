package com.techgarden.tasks.tree.model.types.deciduous;

import com.techgarden.tasks.tree.model.elements.Branch;
import com.techgarden.tasks.tree.model.elements.Leaf;

public class DeciduousBranch extends Branch<Deciduous> {

    @Override
    public DeciduousBranch grow() {
        leafs.add(new DeciduousLeaf());
        for (Leaf leaf : leafs) {
            leaf.grow();
        }
        return this;
    }
}