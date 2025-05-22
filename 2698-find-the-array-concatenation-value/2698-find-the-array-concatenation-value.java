class Solution {
    public long findTheArrayConcVal(int[] nums) {
        int r = 0;
        int l = nums.length - 1;
        Long sum = nums.length % 2 == 0 ? 0L : nums[nums.length / 2];
        while(r<l) {
            String s = Integer.toString(nums[r]) + Integer.toString(nums[l]);
            sum = sum + Long.parseLong(s);
            r+=1;
            l-=1;
        }
        return sum;
    }
}