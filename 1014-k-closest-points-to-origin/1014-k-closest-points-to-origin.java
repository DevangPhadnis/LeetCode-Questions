class Solution {
    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<int[]> pq = new PriorityQueue<>(
            Comparator.comparingInt((int[] p) -> p[0] * p[0] + p[1] * p[1]).reversed()
        );
        int n = points.length;
        int ans[][] = new int[k][2];
        for(int i=0;i<n;i++) {
            if(pq.size() == k) {
                pq.add(points[i]);
                pq.poll();
            }
            else {
                pq.add(points[i]);
            }
        }
        int start = 0;
        while(!pq.isEmpty()) {
            ans[start++] = pq.poll();
        }
        return ans;
    }
}