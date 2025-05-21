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
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> answer = new ArrayList<>();
        Deque<TreeNode> dq = new ArrayDeque<>();
        if(root == null) return answer;
        dq.addLast(root);
        while(!dq.isEmpty()) {
            int size = dq.size();
            List<Integer> temp = new ArrayList<>();
            while(size != 0) {
                TreeNode currentNode = dq.removeFirst();
                temp.addLast(currentNode.val);
                if(currentNode.left != null) {
                    dq.addLast(currentNode.left);
                }
                if(currentNode.right != null) {
                    dq.addLast(currentNode.right);
                }
                size--;
            }
            answer.add(temp);
        }
        return answer;
    }
}