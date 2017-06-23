package com.techgarden.tasks.tree.model.deciduous;

import com.techgarden.tasks.tree.model.parts.Leaf;

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