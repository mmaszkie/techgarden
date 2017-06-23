package com.techgarden.tasks.tree.model.coniferous;

import com.techgarden.tasks.tree.model.parts.Trunk;

public class ConiferousTrunk extends Trunk {

    @Override
    public void grow() {
        diameter += 0.2;
        height += 0.2;
    }
}