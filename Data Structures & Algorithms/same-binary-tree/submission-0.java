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
    // 25/9
    // Still missing DA...
    // Approach: I'm gonna use a global variable to store the answer and to break dfs as soon as possible
    boolean ans = true;
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null) return true;
        if (p == null || q == null){
            ans = false;
            return false;
        }
        if (p.val != q.val)
        {
            ans = false;
            return false;
        }
        boolean left = isSameTree(p.left, q.left);
        if(!ans) return false;
        boolean right = isSameTree(p.right, q.right);
        if (!ans) return false;
        return ans;
    }
}
