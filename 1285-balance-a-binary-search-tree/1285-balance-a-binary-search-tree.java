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
    public TreeNode balanceBST(TreeNode root) {
        ArrayList<Integer> sortedNodes = new ArrayList<>();
        findInorder(root, sortedNodes);

        return solve(sortedNodes, 0, sortedNodes.size() - 1);
    }

    public void findInorder(TreeNode root, ArrayList<Integer> sortedNodes) {
        if(root == null) return;

        findInorder(root.left, sortedNodes);
        sortedNodes.add(root.val);
        findInorder(root.right, sortedNodes);
    }

    private TreeNode solve(ArrayList<Integer> nums, int left, int right) {
        if(left > right) return null;

        int mid = left +(right - left) / 2;
        TreeNode node = new TreeNode(nums.get(mid), null, null);

        node.left = solve(nums, left, mid - 1);
        node.right = solve(nums, mid + 1, right);
        return node;
    }
}