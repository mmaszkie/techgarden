package com.techgarden.tasks.trees.model.deciduous;

import com.techgarden.tasks.trees.model.Leaf;

public class DeciduousLeaf extends Leaf<Deciduous> {

    DeciduousLeaf() {
        this.color = Color.GREEN;
    }

    @Override
    public DeciduousLeaf grow() {
        diameter += 0.1;
        return this;
    }
}