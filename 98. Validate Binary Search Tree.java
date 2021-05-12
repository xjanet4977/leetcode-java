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
    public boolean isValidBST(TreeNode root) {
        if (root == null) return true;

        if (root.left != null && root.left.val >= root.val) return false;
        if (root.right != null && root.right.val <= root.val) return false;

        return (isValidBST(root.left) && (getLargest(root.left) < root.val)) && (isValidBST(root.right) && (getSmallest(root.right) > root.val));

    }

    public Long getSmallest(TreeNode node) {
        if (node == null) return Long.MAX_VALUE;
        while (node.left != null) {
            node = node.left;
        }
        return Long.valueOf(node.val);
    }

    public Long getLargest(TreeNode node) {
        if (node == null) return Long.MIN_VALUE;
        while (node.right != null) {
            node = node.right;
        }
        return Long.valueOf(node.val);
    }
}