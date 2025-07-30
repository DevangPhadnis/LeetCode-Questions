class Solution {
    public int firstMissingPositive(int[] nums) {
        HashMap<Integer, Boolean> map = new HashMap<>();
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

        return max+1;
    }
}