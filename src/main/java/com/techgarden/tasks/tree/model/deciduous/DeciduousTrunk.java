package com.techgarden.tasks.tree.model.deciduous;

import com.techgarden.tasks.tree.model.parts.Trunk;

public class DeciduousTrunk extends Trunk {

    @Override
    public void grow() {
        height += 0.2;
        diameter += 0.1;
    }
}