class Solution {
    public int lengthOfLIS(int[] nums) {
        int dp[] = new int[nums.length + 1];
        Arrays.fill(dp, 1);
        for(int i=0;i<nums.length;i++) {
            for(int j=0;j<i;j++) {
                if(nums[i] > nums[j] && dp[j] + 1 > dp[i]) {
                    dp[i] = dp[i] + 1;
                }
            }
        }
        int ans = 0;
        for(int i=0;i<dp.length-1;i++) {
            ans = Math.max(ans, dp[i]);
        }

        return ans;
    }
}