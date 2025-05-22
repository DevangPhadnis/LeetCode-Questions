class Solution {
    public int singleNumber(int[] nums) {
        int ans = 0;
        for(int position = 0;position < 32;position++) {
            int bit_count = 0;
            for(int i=0;i<nums.length;i++) {
                int bit = (nums[i]>>position) & 1;
                bit_count+=bit;
            }
            int mask = (bit_count % 3) << position;
            ans = ans | mask;
        }
        return ans;
    }
}