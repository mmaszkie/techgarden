package com.techgarden.tasks.tree.model;

import com.techgarden.tasks.tree.model.coniferous.ConiferousTree;
import com.techgarden.tasks.tree.model.deciduous.DeciduousTree;
import com.techgarden.tasks.tree.model.parts.*;
import org.junit.Test;

import java.util.Iterator;

import static org.assertj.core.api.Assertions.assertThat;

public class TreesTest {

    @Test
    public void shouldDeciduousTreeGrowCorrectly() {
        // given
        Tree tree = new DeciduousTree();

        Trunk trunk = tree.trunk;
        Top top = tree.top;

        assertTreeHeight(tree, 0);
        assertTopSize(top, 0);
        assertTrunkDiameter(trunk, 0);

        // when
        tree.grow();

        // then
        assertTreeHeight(tree, 2);
        assertTrunkDiameter(trunk, 0.1);
        assertTopSize(top, 1);

        Branch branch = (Branch) top.branches.iterator().next();
        assertBranchSize(branch, 1);

        Iterator<Leaf> leafsIterator = branch.leafs.iterator();
        Leaf leaf = leafsIterator.next();

        assertLeafColor(leaf, Leaf.Color.GREEN);
        assertLeafDiameter(leaf, 0.1);
    }

    @Test
    public void shouldConiferousTreeGrowCorrectly() {
        // given
        Tree tree = new ConiferousTree();

        Trunk trunk = tree.trunk;
        Top top = tree.top;

        assertTreeHeight(tree, 0);
        assertTrunkDiameter(trunk, 0);
        assertTopSize(top, 0);

        // when
        tree.grow();

        // then
        assertTreeHeight(tree, 1);
        assertTrunkDiameter(trunk, 0.2);
        assertTopSize(top, 1);

        Branch branch = (Branch) top.branches.iterator().next();
        assertBranchSize(branch, 2);

        Iterator<Leaf> leafsIterator = branch.leafs.iterator();

        Leaf firstLeaf = leafsIterator.next();
        assertLeafColor(firstLeaf, Leaf.Color.BROWN);
        assertLeafDiameter(firstLeaf, 0.2);

        Leaf secondLeaf = leafsIterator.next();
        assertLeafColor(secondLeaf, Leaf.Color.BROWN);
        assertLeafDiameter(secondLeaf, 0.2);
    }

    private void assertTreeHeight(Tree tree, double height) {
        assertThat(tree.getHeight()).isEqualTo(height);
    }

    private void assertTrunkDiameter(Trunk trunk, double diameter) {
        assertThat(trunk.diameter).isEqualTo(diameter);
    }

    private void assertTopSize(Top top, int size) {
        assertThat(top.branches.size()).isEqualTo(size);
    }

    private void assertBranchSize(Branch branch, int size) {
        assertThat(branch.leafs.size()).isEqualTo(size);
    }

    private void assertLeafColor(Leaf leaf, Leaf.Color color) {
        assertThat(leaf.color).isEqualTo(color);
    }

    private void assertLeafDiameter(Leaf leaf, double diameter) {
        assertThat(leaf.diameter).isEqualTo(diameter);
    }
}