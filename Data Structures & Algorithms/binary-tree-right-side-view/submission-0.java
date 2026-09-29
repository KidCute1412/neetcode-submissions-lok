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
    public List<Integer> rightSideView(TreeNode root) {
        // 29/9
        // I'm missing DA so much, damnnnn
        // Intuition: DFS but visit the right node first, we need to count for level and choose the first one which appears in that level.
        // I'm gonna use a list as the resulted list and also that list is used to count level
        List<Integer> ans = new ArrayList<>();
        if (root == null) return ans;
        DFS(root, 1, ans);
        return ans;
    }
    // Int is passed by value but List is passed by reference, so that level won't remember its descendant recursion but list does
    private void DFS(TreeNode root, int level, List<Integer> array)
    {
        if (root == null) return;
        if (level > array.size())
        {
            array.add(root.val);
        }
        DFS(root.right, level + 1, array);
        DFS(root.left, level + 1, array);
    }
    
}
