class Solution {
    public int specialArray(int[] nums) {
        for(int i=0;i<=nums.length;i++) {
            int count = 0;
            for(int j=0;j<nums.length;j++) {
                if(nums[j] < i) {
                    continue;
                }
                else {
                    count++;
                }
            }
            if(i == count) return i;
        }
        return -1;
    }
}