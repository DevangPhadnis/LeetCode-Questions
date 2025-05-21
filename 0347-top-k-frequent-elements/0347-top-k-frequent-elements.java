class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        PriorityQueue<Map.Entry<Integer, Integer>> pq = new PriorityQueue<>(Comparator.comparingInt(entry -> entry.getValue()));
        int size = 0;
        int ans[] = new int[k];
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        for(int i=0;i<nums.length;i++) {
            int value = hashMap.getOrDefault(nums[i], 0);
            hashMap.put(nums[i], ++value);
        }

        for(Map.Entry<Integer, Integer> mp: hashMap.entrySet()) {
            if(size < k) {
                pq.add(mp);
                size++;
            }
            else {
                pq.add(mp);
                pq.poll();
            }
        }
        size = 0;
        while(size<k) {
            Map.Entry<Integer, Integer> map = pq.poll();
            ans[size] = map.getKey();
            size++;
        }

        return ans;
    }
}