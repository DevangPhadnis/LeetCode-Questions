class Solution {
    public int maxFrequency(int[] nums, int k) {
        Arrays.sort(nums);
        int start = 1;
        int end = nums.length;
        int ans = 0;
        while(start <= end) {
            int middle = start + (end - start)/2;
            if(isPossible(middle, nums, k)) {
                ans = middle;
                start = middle + 1;
            }
            else {
                end = middle - 1;
            }
        }
        return ans;
    }

    public boolean isPossible(int reqFrequency, int nums[], int k) {
        int start = 0;
        int end = 0;
        Long total = 0L;
        while(end < nums.length) {
            total+= Long.valueOf(nums[end]);

            if(end-start + 1 > reqFrequency) {
                total = total - Long.valueOf(nums[start]);
                start++;
            }
            if(end-start + 1 == reqFrequency) {
                Long targetSum = Long.valueOf(Long.valueOf(nums[end]) 
                * Long.valueOf(reqFrequency));
                if(targetSum - total <= Long.valueOf(k)) return true;
            }
            end++;
        }
        return false;
    }
}