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
    public List<Integer> getAllElements(TreeNode root1, TreeNode root2) {
        ArrayList<Integer> inorderFirstTree = new ArrayList<>();
        ArrayList<Integer> inorderSecondTree = new ArrayList<>();
        List<Integer> ans = new ArrayList<>();
        
        findInorder(root1, inorderFirstTree);
        findInorder(root2, inorderSecondTree);
        
        int i=0, j=0;
        while(i<inorderFirstTree.size() && j<inorderSecondTree.size()) {
            if(inorderFirstTree.get(i) < inorderSecondTree.get(j)) {
                ans.add(inorderFirstTree.get(i));
                i++;
            }
            else {
                ans.add(inorderSecondTree.get(j));
                j++;
            }
        }
        while(i<inorderFirstTree.size()) {
            ans.add(inorderFirstTree.get(i));
            i++;
        }
        while(j<inorderSecondTree.size()) {
            ans.add(inorderSecondTree.get(j));
            j++;
        }
        return ans;
    }

    public void findInorder(TreeNode root, ArrayList<Integer> inorder) {
        if(root == null) return;
        
        findInorder(root.left, inorder);
        inorder.add(root.val);
        findInorder(root.right, inorder);
    }
}