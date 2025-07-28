class Solution {
    public boolean canJump(int[] nums) {
        int dp[] = new int[nums.length];
        Arrays.fill(dp, -1);
        return helper(nums, 0, dp) == 1 ? true : false;
    }

    public int helper(int[] nums, int idx, int[] dp) {
        if(idx == nums.length - 1) return 1;
        else if(nums[idx] == 0 && idx != nums.length -1) return 0;

        if(dp[idx] != -1) return dp[idx];
        int result = 0;
        for(int i=1;i<=nums[idx];i++) {
            result = helper(nums, idx+i, dp);
            if(result == 1) {
                break;
            }
        }
        dp[idx] = result;
        return dp[idx];
    }
}