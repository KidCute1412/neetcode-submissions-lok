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
        // Approach 2: This solution still use queue to perform BFS. But it's more clear because we can utilize queue.size() to loop exactly every node of a number, instead of while (!isEmpty) like approach 1
        List<List<Integer>> ans = new ArrayList<>();
        Deque<TreeNode> queue = new ArrayDeque<>();
        if (root == null) return ans;
        queue.offer(root);
        while (!queue.isEmpty())
        {
            int n = queue.size();
            List<Integer> row = new ArrayList<>();
            for(int i = 0; i < n; ++i)
            {
                TreeNode cur = queue.poll();
                row.add(cur.val);
                if (cur.left != null) queue.offer(cur.left);
                if (cur.right != null) queue.offer(cur.right);
            }
            ans.add(row);
        }
        return ans;
    }
}
