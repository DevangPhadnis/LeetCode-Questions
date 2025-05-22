class Solution {
    public int rob(int[] nums) {
        if(nums.length == 1) return nums[0];
        else if(nums.length == 1) return Math.max(nums[0], nums[1]);
        int[] dp = new int[nums.length];
        int[] dp2 = new int[nums.length];
        Arrays.fill(dp, -1);
        Arrays.fill(dp2, -1);
        return Math.max(helper(0, nums, dp, nums.length - 1), 
        helper(1, nums,dp2, nums.length) );
    }

    public int helper(int index, int[] nums, int[] dp, int end) {
        if(index>=end) return 0;

        if(dp[index] != -1) return dp[index];

        int rob = nums[index] + helper(index + 2, nums, dp, end);

        int notRob = helper(index + 1, nums, dp, end);

        dp[index] = Math.max(rob, notRob); 

        return dp[index];
    }
}