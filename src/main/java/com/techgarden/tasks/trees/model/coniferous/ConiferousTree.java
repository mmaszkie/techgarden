package com.techgarden.tasks.trees.model.coniferous;

import com.techgarden.tasks.trees.model.Tree;

public class ConiferousTree extends Tree<Coniferous> {

    public ConiferousTree() {
        this.trunk = new ConiferousTrunk();
        this.top = new ConiferousTop();
    }
}