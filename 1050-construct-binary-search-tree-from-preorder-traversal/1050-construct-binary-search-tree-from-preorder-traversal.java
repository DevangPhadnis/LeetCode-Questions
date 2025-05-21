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
    public TreeNode bstFromPreorder(int[] preorder) {
        int[] index = new int[1];
        return constructbstFromPreorder(preorder, index, Integer.MAX_VALUE);
    }

    public TreeNode constructbstFromPreorder(int []preorder, int[] index, int bound) {
        if(index[0] == preorder.length || preorder[index[0]] > bound) return null;

        TreeNode root = new TreeNode(preorder[index[0]++]);
        root.left = constructbstFromPreorder(preorder, index, root.val);
        root.right = constructbstFromPreorder(preorder, index, bound);

        return root;
    }
}