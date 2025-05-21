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
    public boolean findTarget(TreeNode root, int k) {
        ArrayList<Integer> ans = new ArrayList<>();
        findInorder(root, ans);

        int start = 0;
        int end = ans.size() - 1;

        while(start < end) {
            int sum = ans.get(start) + ans.get(end);
            if(sum == k) return true;
            else if(sum > k) end--;
            else start++;
        }
        return false;
    }

    public void findInorder(TreeNode root, ArrayList<Integer> ans) {
        if(root == null) return;

        findInorder(root.left, ans);
        ans.add(root.val);
        findInorder(root.right, ans);
    }
}