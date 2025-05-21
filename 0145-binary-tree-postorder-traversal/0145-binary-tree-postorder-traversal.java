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
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        findPostOrder(root, ans);
        return ans;
    }

    public void findPostOrder(TreeNode root, List<Integer> ans) {
        if(root == null) return;

        findPostOrder(root.left, ans);
        findPostOrder(root.right, ans);
        ans.add(root.val);
    }
}