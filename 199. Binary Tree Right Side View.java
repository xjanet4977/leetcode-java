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
        List<Integer> result = new ArrayList<>();
        if (root == null) return result;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while(queue.size() != 0) {
            int len = queue.size();
            for (int i = 0; i< len; i++) {
                TreeNode node = queue.poll();
                if (i == len - 1) result.add(node.val);
                if (node.left != null) queue.offer(node.left);
                if (node.right != null) queue.offer(node.right);
            }
        }

        return result;
    }
}

//recursion

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
        List<Integer> result = new ArrayList<>();
        if (root == null) return result;

        result.add(root.val);
        List<Integer> right = new ArrayList<>();
        List<Integer> left = new ArrayList<>();
        if (root.right != null) right = rightSideView(root.right);
        if (root.left != null) left = rightSideView(root.left);

        if (right == null) result.addAll(left);
        if (left == null) result.addAll(right);

        if (right != null && left != null) {
            result.addAll(right);
            if (right.size() < left.size())
                result.addAll(left.subList(right.size(), left.size()));

        }
        return result;
    }
}