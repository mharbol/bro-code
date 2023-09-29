
package io.github.mharbol.leetcode;

import java.util.Arrays;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import io.github.mharbol.util.TreeNode;

/**
 * InorderTreeTraversalTest
 *
 * Test class for InorderTreeTraversal.java
 */
public class InorderTreeTraversalTest {

    private InorderTreeTraversal cut;
    private TreeNode root;
    private List<Integer> expeceted;
    private List<Integer> actual;

    @Before
    public void setup() {
        cut = new InorderTreeTraversal();
    }

    @Test
    public void testLeetCode1() {
        root = new TreeNode(1, null, new TreeNode(2, new TreeNode(3), null));
        expeceted = Arrays.asList(1, 3, 2);
        actual = cut.inorderTraversal(root);
        Assert.assertEquals(expeceted, actual);
    }
}
