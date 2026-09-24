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
    public int maxDepth(TreeNode root) {
        return DFS(root);
    }
    public int DFS(TreeNode root)
    {
        // with primitive type, java always pass-by-value, we can't use technique like int& maxDepth to save the reference
        if(root == null)
        {
            return 0;
        }
        int left = DFS(root.left);
        int right = DFS(root.right);
        return 1 + Math.max(left, right);
    }
}
