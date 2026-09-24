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
    int maxDiameter = 0;
    public int diameterOfBinaryTree(TreeNode root) {
        // 24/9
        // Because we can't traverse a node twice, so the diameter is the sum of the left height and right height of a node. We find that maximun value.
        DFS(root);
        return maxDiameter;
    }
    public int DFS(TreeNode root)
    {
        if (root == null) return 0;
        int left = DFS(root.left);
        int right = DFS(root.right);
        maxDiameter = Math.max(maxDiameter, left + right);
        return Math.max(left + 1, right + 1);
    }
}
