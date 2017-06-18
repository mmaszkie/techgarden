package com.techgarden.tasks.trees.model.coniferous;

import com.techgarden.tasks.trees.model.Trunk;

public class ConiferousTrunk extends Trunk {

    @Override
    public void grow() {
        diameter += 0.2;
    }
}