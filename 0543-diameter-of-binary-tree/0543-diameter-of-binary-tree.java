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
    public int diameterOfBinaryTree(TreeNode root) {
        int ans[] = new int[1];
        ans[0] = Integer.MIN_VALUE;
        helper(root, ans);
        return ans[0] - 1;
    }

    public int helper(TreeNode root, int ans[]) {
        if(root == null) return 0;

        int lh = helper(root.left, ans);
        int rh = helper(root.right, ans);


        // Include -- Root is excluded so we can take both lh, rh
        int rootIsExcluded = lh + rh + 1;

        // Exlude -- Root is included, we will take only the max of lh or rh
        int rootIsIncluded = Math.max(lh, rh) +1;

        ans[0] = Math.max(ans[0], Math.max(rootIsExcluded, rootIsIncluded));

        return rootIsIncluded;
    }
}