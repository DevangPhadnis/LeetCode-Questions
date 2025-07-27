class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        helper(nums, 0, ans, new ArrayList<>());
        return ans;
    }

    public void helper(int[] nums, int idx, List<List<Integer>> ans, List<Integer> subset) {
        if(idx >= nums.length) {
            ans.add(new ArrayList<>(subset));
            return;
        }

        subset.add(nums[idx]);
        helper(nums, idx + 1, ans, subset);
        if(subset.size() > 0) {
            subset.removeLast();
        }
        helper(nums, idx+1, ans, subset);
    }
}