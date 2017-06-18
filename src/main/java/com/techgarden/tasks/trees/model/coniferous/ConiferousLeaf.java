package com.techgarden.tasks.trees.model.coniferous;

import com.techgarden.tasks.trees.model.Leaf;

public class ConiferousLeaf extends Leaf<Coniferous> {

    ConiferousLeaf() {
        this.color = Color.BROWN;
    }

    @Override
    public ConiferousLeaf grow() {
        diameter += 0.2;
        return this;
    }
}