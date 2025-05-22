class Solution {
    public int subarraySum(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();

        int count = 0;
        int prefixSum = 0;
        map.put(0, 1);
        for(int i=0;i<nums.length;i++) {
            prefixSum = prefixSum + nums[i];
            if(map.getOrDefault((prefixSum - k), 0) != 0) {
                count = count + map.getOrDefault((prefixSum - k), 0);
            }
            int value = map.getOrDefault(prefixSum, 0);
            map.put(prefixSum, ++value);
        }
        return count;
    }
}