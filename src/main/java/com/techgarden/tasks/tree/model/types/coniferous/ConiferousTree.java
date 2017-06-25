package com.techgarden.tasks.tree.model.types.coniferous;

import com.techgarden.tasks.tree.model.Tree;

public class ConiferousTree extends Tree<Coniferous> {

    public ConiferousTree() {
        this.trunk = new ConiferousTrunk();
        this.top = new ConiferousTop();
    }
}