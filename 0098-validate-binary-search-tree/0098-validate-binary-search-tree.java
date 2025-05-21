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
        Long max = Long.MAX_VALUE;
        Long min = Long.MIN_VALUE;
        return validateBST(root, min, max);
    }

    public boolean validateBST(TreeNode root, long min, long max) {
        if(root == null) return true;

        if(!(root.val > min && root.val < max)) return false;

        boolean flagLeft = validateBST(root.left, min, root.val);
        boolean flagRight = validateBST(root.right, root.val, max);

        return flagLeft && flagRight;
    }
}