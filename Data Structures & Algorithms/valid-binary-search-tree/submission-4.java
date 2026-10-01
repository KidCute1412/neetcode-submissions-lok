/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

class Solution {
    private Integer prev = null;
    public boolean isValidBST(TreeNode root) {
        // Approach 2: Still think the same way is that inorder traverse must be ascending. But this code is cleaner
        prev = null;
        return inorder(root);
    }
    private boolean inorder(TreeNode node)
    {
        if (node == null) return true;
        // Left first
        if (!inorder(node.left)) return false;
        if (prev != null && node.val <= prev) return false;
        prev = node.val;
        return inorder(node.right);
    }
}
