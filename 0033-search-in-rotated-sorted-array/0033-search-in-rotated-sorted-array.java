class Solution {
    public int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        int mid = 0;

        while(left < right) {
            mid = (left + right)/2;

            if(nums[mid] <= nums[right]) right = mid;
            else left = mid+1;
        }
        int l = 0, r = nums.length - 1;
        if(target >= nums[left] && target <= nums[nums.length - 1]) l = left;
        else r = left - 1;

        while(l<=r) {
            int middle = (l + r) / 2;
            if(nums[middle] == target) return middle;
            else if(target >= nums[middle]) l = middle + 1;
            else r = middle - 1;
        }
        return -1;
    }
}