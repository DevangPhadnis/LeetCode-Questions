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
    public boolean isBalanced(TreeNode root) {
        int height = checkBalanced(root);
        if(height != -1) {
            return true;
        }
        else {
            return false;
        }
    }
    public int checkBalanced(TreeNode root) {
        if(root == null) return 0;

        int lh = checkBalanced(root.left);
        if(lh == -1) return -1;

        int rh = checkBalanced(root.right);
        if(rh == -1) return -1;

        if(Math.abs(lh - rh) > 1) return -1;

        return Math.max(lh, rh) + 1;
    }
}