class Solution {
    public List<Integer> majorityElement(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        List<Integer> ans = new ArrayList<>();
        for(int i=0;i<nums.length;i++) {
            int value = map.getOrDefault(nums[i], 0);
            map.put(nums[i], ++value);
        }

        for(Map.Entry<Integer, Integer> mp: map.entrySet()) {
            if(mp.getValue() > (nums.length / 3)) ans.add(mp.getKey());
        }

        return ans;
    }
}