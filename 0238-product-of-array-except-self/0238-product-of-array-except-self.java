class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] ans = new int[nums.length];
        int product = 1;
        for(int i=0;i<nums.length;i++) {
            if(i != 0) {
                ans[i] = ans[i-1] * nums[i];
            }
            else {
                ans[i] = nums[i];
            }
        }
        for(int i=nums.length-1;i>=0;i--) {
            if(i == 0) {
                ans[i] = product;
            }
            else {
                ans[i] = ans[i-1] * product;
                product = product * nums[i];
            }
        }
        return ans;
    }
}