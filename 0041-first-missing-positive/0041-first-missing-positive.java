class Solution {
    public int firstMissingPositive(int[] nums) {
        /* HashMap<Integer, Boolean> map = new HashMap<>();
        int max = Integer.MIN_VALUE;
        for(int i=0;i<nums.length;i++) {
            map.put(nums[i], true);
            max = Math.max(max, nums[i]);
        }
        if(max < 0) return 1;
        for(int i=1;i<max;i++) {
            if(!map.getOrDefault(i, false)) {
                return i;
            }
        }

        return max+1; */

        int n = nums.length;

        for(int i=0;i<n;i++) {
            if(nums[i] <= 0 || nums[i] > n) {
                nums[i] = n+1;
            }
        }

        for(int i=0;i<n;i++) {
            int value = Math.abs(nums[i]);
            if(value <= n && nums[value-1] > 0) {
                nums[value-1] = -nums[value-1];
            }
        }

        for(int i=0;i<n;i++) {
            if(nums[i]>0) return i+1;
        }

        return n+1;
    }
}