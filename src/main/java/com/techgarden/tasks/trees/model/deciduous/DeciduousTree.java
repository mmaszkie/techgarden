package com.techgarden.tasks.trees.model.deciduous;

import com.techgarden.tasks.trees.model.Tree;

public class DeciduousTree extends Tree<Deciduous> {

    public DeciduousTree() {
        this.trunk = new DeciduousTrunk();
        this.top = new DeciduousTop();
    }
}