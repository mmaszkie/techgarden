package com.techgarden.tasks.trees.model;

import com.techgarden.tasks.trees.model.Leaf.Color;
import com.techgarden.tasks.trees.model.coniferous.ConiferousTree;
import com.techgarden.tasks.trees.model.deciduous.DeciduousTree;
import org.junit.Test;

import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

public class TreesTest {

    @Test
    public void shouldDeciduousTreeGrowCorrectly() {
        // given
        Tree tree = new DeciduousTree();

        Trunk trunk = tree.trunk;
        assertTrunk(trunk, 0);

        Set<Branch> branches = tree.top.branches;
        assertTop(branches, 0);

        // when
        tree.grow();

        // then
        assertTrunk(trunk, 0.1);
        assertTop(branches, 1);

        Branch branch = branches.iterator().next();
        assertBranch(branch, 1);

        Set<Leaf> leafs = branch.leafs;
        assertLeaf(leafs.iterator().next(), Color.GREEN, 0.1);
    }

    @Test
    public void shouldConiferousTreeGrowCorrectly() {
        // given
        Tree tree = new ConiferousTree();

        Trunk trunk = tree.trunk;
        assertTrunk(trunk, 0);

        Set<Branch> branches = tree.top.branches;
        assertTop(branches, 0);

        // when
        tree.grow();

        // then
        assertTrunk(tree.trunk, 0.2);
        assertTop(branches, 1);

        Branch branch = branches.iterator().next();
        assertBranch(branch, 2);

        Set<Leaf> leafs = branch.leafs;
        assertLeaf(leafs.iterator().next(), Color.BROWN, 0.2);
        assertLeaf(leafs.iterator().next(), Color.BROWN, 0.2);
    }

    private void assertTrunk(Trunk trunk, double diameter) {
        assertThat(trunk.diameter).isEqualTo(diameter);
    }

    private void assertTop(Set<Branch> branches, int size) {
        assertThat(branches.size()).isEqualTo(size);
    }

    private void assertBranch(Branch branch, int size) {
        Set<Leaf> leafs = branch.leafs;
        assertThat(leafs.size()).isEqualTo(size);
    }

    private void assertLeaf(Leaf leaf, Color color, double diameter) {
        assertThat(leaf.color).isEqualTo(color);
        assertThat(leaf.diameter).isEqualTo(diameter);
    }
}