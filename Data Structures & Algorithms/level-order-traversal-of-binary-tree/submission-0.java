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
    public List<List<Integer>> levelOrder(TreeNode root) {
        // 28/9
        // Intuition: I feel like I need to use a queue
        Deque<TreeNode> queue = new ArrayDeque<>();
        List<List<Integer>> ans = new ArrayList<>();
        if (root == null) return ans;
        queue.offer(root);
        while (!queue.isEmpty())
        {
            List<TreeNode> rowNode = new ArrayList<>();
            List<Integer> row = new ArrayList<>();
            while (!queue.isEmpty())
            {
                TreeNode node = queue.poll();
                rowNode.add(node);
                row.add(node.val);
            }
            ans.add(row);
            for (TreeNode x : rowNode)
            {
                if (x.left != null) queue.offer(x.left);
                if (x.right != null) queue.offer(x.right);
            }
        }
        return ans;
    }
}
