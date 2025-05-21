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
    public int widthOfBinaryTree(TreeNode root) {
        int ans = 0;
        Queue<Map.Entry<TreeNode, Integer>> q = new LinkedList<>();
        q.add(Map.entry(root, 0));
        while(!q.isEmpty()) {
            int size = q.size();
            int front = 0, end = 0;
            for(int i=0;i<size;i++) {
                Map.Entry<TreeNode, Integer> mp = q.poll();
                TreeNode temp = mp.getKey();
                Integer level = mp.getValue();
                if(i==0) front = mp.getValue();
                if(i==size -1) end = mp.getValue();

                if(temp.left != null) {
                    q.add(Map.entry(temp.left, 2*level + 1));
                }
                if(temp.right != null) {
                    q.add(Map.entry(temp.right, 2*level + 2));
                }
            }
            ans = Math.max(ans, (end - front + 1));
        }
        return ans;
    }
}