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
    int prev = 0;
    boolean ans = true;
    public boolean isValidBST(TreeNode root) {
        // 1/10
        // A new journey
        // I still love DA :)))
        // Intuition: Traverse a binary search tree in-order, it must be ascending...
        // Oke it's easy
        if (root == null) return true;
        TreeNode leftMost = findSmallest(root);
        prev = leftMost.val;
        DFS(root, leftMost);
        return ans;
    }
    public TreeNode findSmallest(TreeNode root)
    {
        if (root.left == null) return root;
        return findSmallest(root.left);
    }
    public void DFS(TreeNode root, TreeNode leftMost)
    {
        if (root == null) return;
        DFS(root.left, leftMost);
        if (root.val > prev || root == leftMost) prev = root.val;
        else ans = false;
        DFS(root.right, leftMost);
    }
}
