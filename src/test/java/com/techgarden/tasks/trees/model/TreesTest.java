package com.techgarden.tasks.trees.model;

import com.techgarden.tasks.trees.model.Leaf.Color;
import com.techgarden.tasks.trees.model.coniferous.ConiferousTree;
import com.techgarden.tasks.trees.model.deciduous.DeciduousTree;
import org.junit.Test;

import java.util.Iterator;

import static org.assertj.core.api.Assertions.assertThat;

public class TreesTest {

    @Test
    public void shouldDeciduousTreeGrowCorrectly() {
        // given
        Tree tree = new DeciduousTree();

        Trunk trunk = tree.trunk;
        assertTrunk(trunk, 0);

        Top top = tree.top;
        assertTop(top, 0);

        // when
        tree.grow();

        // then
        assertTrunk(trunk, 0.1);
        assertTop(top, 1);

        Branch branch = (Branch) top.branches.iterator().next();
        assertBranch(branch, 1);

        Iterator<Leaf> leafsIterator = branch.leafs.iterator();
        assertLeaf(leafsIterator.next(), Color.GREEN, 0.1);
    }

    @Test
    public void shouldConiferousTreeGrowCorrectly() {
        // given
        Tree tree = new ConiferousTree();

        Trunk trunk = tree.trunk;
        assertTrunk(trunk, 0);

        Top top = tree.top;
        assertTop(top, 0);

        // when
        tree.grow();

        // then
        assertTrunk(trunk, 0.2);
        assertTop(top, 1);

        Branch branch = (Branch) top.branches.iterator().next();
        assertBranch(branch, 2);

        Iterator<Leaf> leafsIterator = branch.leafs.iterator();
        assertLeaf(leafsIterator.next(), Color.BROWN, 0.2);
        assertLeaf(leafsIterator.next(), Color.BROWN, 0.2);
    }

    private void assertTrunk(Trunk trunk, double diameter) {
        assertThat(trunk.diameter).isEqualTo(diameter);
    }

    private void assertTop(Top top, int size) {
        assertThat(top.branches.size()).isEqualTo(size);
    }

    private void assertBranch(Branch branch, int size) {
        assertThat(branch.leafs.size()).isEqualTo(size);
    }

    private void assertLeaf(Leaf leaf, Color color, double diameter) {
        assertThat(leaf.color).isEqualTo(color);
        assertThat(leaf.diameter).isEqualTo(diameter);
    }
}