package com.techgarden.tasks.tree.model.types.deciduous;

import com.techgarden.tasks.tree.model.elements.Trunk;

public class DeciduousTrunk extends Trunk {

    @Override
    public DeciduousTrunk grow() {
        height += 0.2;
        diameter += 0.1;
        return this;
    }
}