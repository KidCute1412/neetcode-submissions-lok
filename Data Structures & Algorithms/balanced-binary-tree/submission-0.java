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
    boolean ans = true;
    public boolean isBalanced(TreeNode root) {
        if (root == null) return true;
        dfsHeight(root);
        return ans;
    }
    public int dfsHeight(TreeNode root)
    {
        if (root == null) return 0;
        int left = dfsHeight(root.left);
        int right = dfsHeight(root.right);
        if (Math.abs(left - right) > 1)
        {
            ans = false;
        }
        return Math.max(left + 1, right + 1);
        
    }
}
