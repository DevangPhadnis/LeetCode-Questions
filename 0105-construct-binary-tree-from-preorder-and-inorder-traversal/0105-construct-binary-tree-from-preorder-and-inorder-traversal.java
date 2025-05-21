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
    int preorderIndex = 0;
    HashMap<Integer, Integer> map = new HashMap<>();
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        for(int i=0;i<inorder.length;i++) {
            map.put(inorder[i], i);
        }
        return helper(preorder, 0, inorder.length-1);
    }

    public TreeNode helper(int[] preorder, int left, int right) {
        if(left > right) return null;

        int rootValue = preorder[preorderIndex++];
        TreeNode root = new TreeNode(rootValue);

        int index = map.get(rootValue);

        root.left = helper(preorder, left, index - 1);
        root.right = helper(preorder, index + 1, right);

        return root;
    }
}