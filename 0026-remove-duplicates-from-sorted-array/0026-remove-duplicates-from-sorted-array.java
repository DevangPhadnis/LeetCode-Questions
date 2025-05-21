class Solution {
    public int removeDuplicates(int[] nums) {
        int start = 0;
        int end = 1;
        int k = 0;
        while(end < nums.length) {
            if(nums[start] != nums[end]) {
                start++;
                k++;
                int temp = nums[start];
                nums[start] = nums[end];
                nums[end] = nums[start];
            }
            end++;
        }
        return k+1;
    }
}