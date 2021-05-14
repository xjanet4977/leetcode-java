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
/*
o: the sum of values [low, high]
i: root - node of bst, low - int, high - int
c: none
e: if root is null return 0

// base case:
  - if root.val < low, only need to consider the right tree
  - if root.val > high, only need to consider the left tree.
  - if  low< root.val < high, sum += root.val
// recursion case:
   - rangeSumBST(node, low, high), output is the sum
*/


class Solution {
    public int rangeSumBST(TreeNode root, int low, int high) {
        int sum = 0;
        if (root == null) return 0;
        if (root.val < low) sum += rangeSumBST(root.right, low, high);
        else if (root.val > high) sum += rangeSumBST(root.left, low, high);
        else sum += root.val + rangeSumBST(root.left, low, high) + rangeSumBST(root.right, low, high);

        return sum;
    }
}