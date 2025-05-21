class Solution {
    public int maxSubArray(int[] nums) {
        int start = 0;
        int end = 0;
        int sum = 0;
        int ans = Integer.MIN_VALUE;

        while(end < nums.length) {
            sum+= nums[end];
            if(sum > ans) {
                ans = sum;
            }
            if(sum < 0) {
                sum = 0;
            }
            end++;
        }
        return ans;
    }
}