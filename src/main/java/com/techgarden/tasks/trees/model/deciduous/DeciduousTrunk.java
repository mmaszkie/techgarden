package com.techgarden.tasks.trees.model.deciduous;

import com.techgarden.tasks.trees.model.Trunk;

public class DeciduousTrunk extends Trunk {

    @Override
    protected void grow() {
        diameter += 0.1;
    }
}