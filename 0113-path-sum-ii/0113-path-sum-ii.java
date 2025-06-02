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
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> ans = new ArrayList<>();

        helper(root,0, targetSum, new ArrayList<>(), ans);
        return ans;
    }

    public void helper(TreeNode root, int sum, int target, List<Integer> path, List<List<Integer>> ans) {
        if(root == null) return;

        if(root.left == null && root.right == null && (sum +  root.val) == target) {
            path.add(root.val);
            ans.add(new ArrayList<>(path));
            path.removeLast();
            return;
        }

        path.add(root.val);
        helper(root.left, sum+root.val ,target, path, ans);
        helper(root.right, sum+root.val, target, path, ans);
        path.removeLast();
    }
}