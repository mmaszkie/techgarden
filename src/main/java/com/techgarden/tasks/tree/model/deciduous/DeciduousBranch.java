package com.techgarden.tasks.tree.model.deciduous;

import com.techgarden.tasks.tree.model.parts.Branch;
import com.techgarden.tasks.tree.model.parts.Leaf;

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