package com.techgarden.tasks.trees.model.deciduous;

import com.techgarden.tasks.trees.model.Branch;
import com.techgarden.tasks.trees.model.Leaf;

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