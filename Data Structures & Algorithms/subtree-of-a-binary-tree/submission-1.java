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
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        // 26/9
        // Missing DA too much :(
        // I'm trying to be better...
        // Intuition: DFS in the root tree, whenever i meet the root node of subroot tree, i start to check it...
        if (root == null || subRoot == null) return false;
        boolean check = false;
        if (root.val == subRoot.val)
        {
            check = isEquivalentTree(root, subRoot);
        }
        if (check) return true;
        return isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot);
    }
    public boolean isEquivalentTree(TreeNode root, TreeNode subRoot)
    {
        if (root == null && subRoot == null) return true;
        if (root == null || subRoot == null) return false;
        if (root.val != subRoot.val) return false;
        return isEquivalentTree(root.left, subRoot.left) && isEquivalentTree(root.right, subRoot.right);
    }
}
