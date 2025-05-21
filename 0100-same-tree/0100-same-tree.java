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
    public boolean isSameTree(TreeNode p, TreeNode q) {
        return solve(p, q);
    }
    public boolean solve(TreeNode leftNode, TreeNode rightNode) {
        if(leftNode == null && rightNode == null) {
            return true;
        }

        if(leftNode == null || rightNode == null) return false;

        return leftNode.val == rightNode.val && solve(leftNode.left, rightNode.left) && solve(leftNode.right, rightNode.right);
    }
}