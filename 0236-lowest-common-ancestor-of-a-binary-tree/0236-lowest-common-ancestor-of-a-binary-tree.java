/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null) return null;

        if(root.val == p.val) return p;
        else if(root.val == q.val) return q;

        TreeNode left = lowestCommonAncestor(root.left, q, p);
        TreeNode right = lowestCommonAncestor(root.right, q, p);

        if(left == null) return right;

        else if(right == null) return left;

        else return root;
    }
}