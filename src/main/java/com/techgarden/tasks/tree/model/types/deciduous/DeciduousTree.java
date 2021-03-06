package com.techgarden.tasks.tree.model.types.deciduous;

import com.techgarden.tasks.tree.model.Tree;

public class DeciduousTree extends Tree<Deciduous> {

    public DeciduousTree() {
        this.trunk = new DeciduousTrunk();
        this.top = new DeciduousTop();
    }
}