
package io.github.mharbol.util;

import org.junit.Assert;

import org.junit.Before;
import org.junit.Test;

/**
 * TreeNodeTest
 * Test class for {@link TreeNode}
 */
public class TreeNodeTest {

    private TreeNode cut;

    @Before
    public void setup() {
    }

    @Test
    public void testBasicConstructor() {
        cut = new TreeNode(12);

        Assert.assertEquals(12, cut.val);
        Assert.assertNull(cut.left);
        Assert.assertNull(cut.right);
    }

    @Test
    public void testNestedConstructor() {
        cut = new TreeNode(1, new TreeNode(2), new TreeNode(3));

        Assert.assertEquals(1, cut.val);
        Assert.assertEquals(2, cut.left.val);
        Assert.assertEquals(3, cut.right.val);
        Assert.assertNull(cut.left.left);
        Assert.assertNull(cut.left.right);
        Assert.assertNull(cut.right.left);
        Assert.assertNull(cut.right.right);
    }

    @Test
    public void testBasicEquality() {
        TreeNode treeNode1 = new TreeNode(1, new TreeNode(2), new TreeNode(3));
        TreeNode treeNode2 = new TreeNode(1, new TreeNode(2), new TreeNode(3));

        Assert.assertEquals(treeNode1, treeNode2);
    }

    @Test
    public void testEqualitySameObject() {
        cut = new TreeNode(1, new TreeNode(2), new TreeNode(3));

        Assert.assertEquals(cut, cut);
    }

    @Test
    public void testBasicInequality() {
        TreeNode treeNode1 = new TreeNode(1, new TreeNode(2), new TreeNode(3));
        TreeNode treeNode2 = new TreeNode(1, new TreeNode(2), new TreeNode(4));

        Assert.assertNotEquals(treeNode1, treeNode2);
    }

    @Test
    public void testNullInequality() {
        TreeNode treeNode1 = new TreeNode(1, new TreeNode(2), new TreeNode(3));
        TreeNode treeNode2 = null;

        Assert.assertNotEquals(treeNode1, treeNode2);
    }

    @Test
    public void testInequalityOtherType() {
        cut = new TreeNode(1, new TreeNode(2), new TreeNode(3));
        String notCut = "not a TreeNode";

        Assert.assertNotEquals(cut, notCut);
        Assert.assertNotEquals(notCut, cut);
    }
}
