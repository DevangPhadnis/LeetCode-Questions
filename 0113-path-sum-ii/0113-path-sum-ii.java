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
        helper(root, targetSum, new ArrayList<>(), 0, ans);
        return ans;
    }

    public void helper(TreeNode root, int target, List<Integer> path, int sum, 
    List<List<Integer>> ans) {
        if(root == null) return;

        if(root.left == null && root.right == null && (sum + root.val) == target) {
            path.add(root.val);
            ans.add(new ArrayList<>(path));
            path.removeLast();
            return;
        }

        path.add(root.val);
        helper(root.left, target, path, sum + root.val, ans);
        helper(root.right, target, path, sum + root.val, ans);
        path.removeLast();
    }
}