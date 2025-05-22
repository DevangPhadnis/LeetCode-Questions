class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int start = 0, end = 0, n = nums.length, sum = 0, ans = Integer.MAX_VALUE;
        while(end < n) {
            sum += nums[end];
            while(start <= end && sum>=target) {
                int length = (end-start)+1;
                ans = Math.min(ans, length);
                sum = sum - nums[start];
                start++;
            }
            end++;
        }
        return ans == Integer.MAX_VALUE ? 0 : ans;
    }
}