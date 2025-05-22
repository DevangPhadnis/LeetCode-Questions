class Solution {
    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        PriorityQueue<int[]> pq = new PriorityQueue<>(
            Comparator.comparingInt((int[] a) -> nums1[a[0]] + nums2[a[1]]));
        List<List<Integer>> ans = new ArrayList<>();
        for(int i=0;i<nums1.length;i++) {
            int arr[] = {i, 0};
            pq.add(arr);
        }

        while(k>0 && !pq.isEmpty()) {
            int arr[] = pq.poll();
            int i = arr[0];
            int j = arr[1];

            ans.add(List.of(nums1[i], nums2[j]));
            
            if(j+1 < nums2.length) {
                pq.add(new int[]{i, j+1});
            }
            --k;
        }
        return ans;
    }
}