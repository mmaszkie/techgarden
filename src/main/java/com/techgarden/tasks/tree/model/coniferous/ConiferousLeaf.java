package com.techgarden.tasks.tree.model.coniferous;

import com.techgarden.tasks.tree.model.parts.Leaf;

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