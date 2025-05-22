class Solution {
    public boolean containsDuplicate(int[] nums) {
        HashMap<Integer, Integer> ans = new HashMap<>();
        for(int i=0;i<nums.length;i++) {
            int value = ans.getOrDefault(nums[i], 0);
            if(value+1 > 1) return true;
            ans.put(nums[i], ++value);
        }
        return false;
    }
}