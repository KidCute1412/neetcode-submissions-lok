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
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        // 27/9
        // If you don't fight for what you want, don't be sad when you lose them...
        // Approach: Just use DFS to search p and q in that binary search tree. whenever 2 pointers meet each other, we mark them a a result candidate.
        // Traverse in Binary search tree, we never need to go back... so we can do it in a while loop, we don't need recursion
        TreeNode ans = root;
        TreeNode p1 = root;
        TreeNode q1 = root;
        while (true)
        {
            if (p1 != p)
            {
                if (p1.val < p.val) p1 = p1.right;
                else p1 = p1.left;
            }
            if (q1 != q)
            {
                if (q1.val < q.val) q1 = q1.right;
                else q1 = q1.left;
            }
            if (p1 == q1) ans = p1;
            if (p1 == p && q1 == q) break;
        }
        return ans;
    }
}
