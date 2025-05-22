class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int n = nums.length;
        for(int i=0;i<n;i++) {
            if(map.getOrDefault(nums[i], -1) != -1) {
                int indexDifference  = i - map.get(nums[i]);
                if(Math.abs(indexDifference) <= k) return true;
            }
            map.put(nums[i], i);
        }
        return false;
    }
}