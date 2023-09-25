
package io.github.mharbol.util;

/**
 * TreeNode
 */
public class TreeNode {

    /**
     * The value this TreeNode holds
     */
    public int val;

    /**
     * The child node to the left of this TreeNode
     */
    public TreeNode left;

    /**
     * The child node to the right of this TreeNode
     */
    public TreeNode right;

    /**
     * Default constructor
     */
    public TreeNode() {
    }

    /**
     * Empty TreeNode constructor
     */
    public TreeNode(int val) {
        this(val, null, null);
    }

    /**
     * Constructs a TreeNode with a left and right node
     */
    public TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }

    /**
     * Checks for equality
     */
    @Override
    public boolean equals(Object obj) {

        if (obj == null || !(obj instanceof TreeNode)) {
            return false;
        }

        TreeNode other = (TreeNode) obj;
        if (this == other) {
            return true;
        }

        if (other.val != this.val) {
            return false;
        }

        boolean leftsEqual = (this.left == null ? other.left == null : this.left.equals(other.left));
        boolean rightsEqual = (this.right == null ? other.right == null : this.right.equals(other.right));

        return leftsEqual && rightsEqual;
    }
}
