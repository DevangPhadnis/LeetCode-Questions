class Solution {
    public int searchInsert(int[] nums, int target) {
        int start = 0;
        int end = nums.length - 1;
        int middle = -1;
        while(start<=end) {
            middle = (start + end) / 2;
            if(nums[middle] == target) {
                return middle;
            }
            else if(nums[middle] < target) start = middle + 1;
            else end = middle - 1;
        }
        return target < nums[middle] ? middle : middle + 1;
    }
}