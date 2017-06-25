package com.techgarden.tasks.tree.model.types.coniferous;

import com.techgarden.tasks.tree.model.elements.Trunk;

public class ConiferousTrunk extends Trunk {

    @Override
    public ConiferousTrunk grow() {
        diameter += 0.2;
        height += 0.2;
        return this;
    }
}