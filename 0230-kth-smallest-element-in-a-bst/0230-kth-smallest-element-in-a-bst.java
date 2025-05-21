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
    public int kthSmallest(TreeNode root, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        findSmallest(root, k, pq);
        return pq.poll();
    }

    public void findSmallest(TreeNode root, int k, PriorityQueue<Integer> pq) {
        if(root == null) return;

        findSmallest(root.left, k, pq);
        if(pq.size() == k) {
            pq.add(root.val);
            pq.poll();
        }
        else {
            pq.add(root.val);
        }
        findSmallest(root.right, k, pq);
    }
}