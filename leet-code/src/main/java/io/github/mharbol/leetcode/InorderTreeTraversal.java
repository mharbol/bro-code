
package io.github.mharbol.leetcode;

import java.util.ArrayList;
import java.util.List;

import io.github.mharbol.util.TreeNode;

/**
 * InorderTreeTraversal
 *
 * Wrapper class for LeetCode 94
 */
public class InorderTreeTraversal {

    /**
     * Traverses a {@link TreeNode} favoring the leftt.
     * 
     * @param root the root of the tree to be traversed
     */
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> nodes = new ArrayList<>();
        if (root == null) {
            return nodes;
        }
        nodes.addAll(inorderTraversal(root.left));
        nodes.add(root.val);
        nodes.addAll(inorderTraversal(root.right));

        return nodes;
    }
}
