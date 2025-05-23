class Solution {
    public int removeElement(int[] nums, int val) {
        int index = 0;
        int ans = 0;
        for(int i=0;i<nums.length;i++) {
            if(nums[i] != val) {
                int temp = nums[i];
                nums[i] = nums[index];
                nums[index] = temp;
                index++;
                ans++;
            }
        }
        return ans;
    }
}