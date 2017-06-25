package com.techgarden.tasks.tree.model.types.coniferous;

import com.techgarden.tasks.tree.model.elements.Leaf;

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