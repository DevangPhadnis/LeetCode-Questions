class Solution {
    class TrieNode {
        TrieNode child[] = new TrieNode[2];
        TrieNode() {
            child[0] = null;
            child[1] = null;
        }
    }
    TrieNode root;
    public int findMaximumXOR(int[] nums) {
        root = new TrieNode();

        for(int i=0;i<nums.length;i++) {
            insert(nums[i]);
        }

        int ans = 0;
        for(int i=0;i<nums.length;i++) {
            ans = Math.max(getMax(nums[i]), ans);
        }

        return ans;
    }

    public void insert(int num) {
        TrieNode curr = root;
        for(int i=31;i>=0;i--) {
            int bit = ((num >> i) & 1);
            if(curr.child[bit] == null) {
                curr.child[bit] = new TrieNode();
            }
            curr = curr.child[bit];
        }
    }

    public int getMax(int num) {
        TrieNode curr = root;
        int ans = 0;
        for(int i=31;i>=0;i--) {
            int bit = ((num>>i) & 1);
            if(curr.child[1-bit] != null) {
                ans = ans | (1<<i);
                curr = curr.child[1-bit];
            }
            else {
                curr = curr.child[bit];
            }
        }
        return ans;
    }
}