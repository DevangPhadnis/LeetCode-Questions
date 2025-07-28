class Solution {
    public int jump(int[] nums) {
        int dp[] = new int[nums.length - 1];
        Arrays.fill(dp, -1);
        return helper(nums, 0, dp);
    }

    public int helper(int[] nums, int idx, int[] dp) {
        if(idx >= nums.length - 1) return 0;

        if(dp[idx] != -1) return dp[idx];
        int result = Integer.MAX_VALUE;
        for(int i=1;i<=nums[idx];i++) {
            int ans = helper(nums, idx+i, dp);
            if(ans != Integer.MAX_VALUE) {
                result = Math.min(1 + ans, result);
            }
        }
        dp[idx] = result;
        return dp[idx];
    }
}