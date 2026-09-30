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
    public int goodNodes(TreeNode root) {
        // 30/9
        // Offer from UNICCS =)))))))))))))))))))))))))))))))
        // I love DA
        // Intuition: DFS, cause int is passed by value so we can utilize it to pass int max, anytime backtrack we still have the correct max
        if (root == null) return 0;
        DFS(root, root.val);
        return ans;
    }
    private void DFS(TreeNode root, int max)
    {
        if (root == null) return;
        if (root.val > max){
            max = root.val;
        }
        DFS(root.left, max);
        DFS(root.right, max);
        // This is backtrack time
        if (root.val >= max)
        {
            ans++;
        }
    }
}
