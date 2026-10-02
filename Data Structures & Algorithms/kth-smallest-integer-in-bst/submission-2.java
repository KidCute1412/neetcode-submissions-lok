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
    private int ans = 0;
    private int count = 0;
    public int kthSmallest(TreeNode root, int k) {
        // 2/10
        // in order will be ascending, so i'm going to traverse the tree in order and just find the k-th element
        count = 0;
        dfs(root, k);
        return ans;
    }
    private void dfs(TreeNode root, int k)
    {
        if (root == null) return;
        if (count >= k) return;
        dfs(root.left, k);
        count++;
        if (count == k) ans = root.val;
        dfs(root.right, k);
    }
}
