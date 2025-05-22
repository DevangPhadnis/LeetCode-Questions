class Solution {
    public int rob(int[] nums) {
        int dp[] = new int[nums.length + 1];
        Arrays.fill(dp, -1);
        return helper(nums, dp,  0);
    }

    public int helper(int[] nums, int[] dp, int index) {
        /* if(index>=nums.length) return 0;

        if(dp[index] != -1) return dp[index];

        int rob = nums[index] + helper(nums, dp, index+2);

        int notRob = helper(nums, dp, index+1);

        dp[index] = Math.max(rob, notRob); */

        if(nums.length == 1) return nums[0];

        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);

        for(int i=2;i<nums.length;i++) {
            dp[i] = Math.max(dp[i-1], dp[i-2] + nums[i]);
        }

        return dp[nums.length - 1];
    }
}