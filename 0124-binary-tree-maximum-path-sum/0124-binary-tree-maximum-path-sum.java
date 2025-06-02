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
    public int maxPathSum(TreeNode root) {
        int ans[] = new int[1];
        ans[0] = Integer.MIN_VALUE;
        helper(root, ans);
        return ans[0];
    }

    public int helper(TreeNode root, int ans[]) {
        if(root == null) return 0;

        int ls = helper(root.left, ans);
        int rs = helper(root.right, ans);

        int rootExcluded = ls + rs + root.val;

        int rootIncluded = Math.max(root.val, Math.max(ls, rs) +  root.val);

        ans[0] = Math.max(ans[0], Math.max(rootIncluded, rootExcluded));

        return rootIncluded;
    }
}