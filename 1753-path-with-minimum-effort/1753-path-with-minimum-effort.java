class Solution {
    public int minimumEffortPath(int[][] heights) {
        int m = heights.length;
        int n = heights[0].length;

        int result[][] = new int[m][n];

        for(int[] ans: result) Arrays.fill(ans, Integer.MAX_VALUE);

        PriorityQueue<Map.Entry<Integer, Map.Entry<Integer, Integer>>> pq = 
        new PriorityQueue<>(
            Comparator.comparingInt(
                Map.Entry<Integer, Map.Entry<Integer,Integer>>::getKey));

        pq.add(Map.entry(0, Map.entry(0, 0)));

        while(!pq.isEmpty()) {
            Map.Entry<Integer, Map.Entry<Integer, Integer>> mp = pq.poll();
            int wt = mp.getKey();
            Map.Entry<Integer, Integer> map = mp.getValue();
            int x = map.getKey();
            int y = map.getValue();

            if(x-1 >= 0) {
                int diff = Math.max(wt, Math.abs(heights[x][y] - heights[x-1][y]));
                if(diff < result[x-1][y]) {
                    result[x-1][y] = diff;
                    pq.add(Map.entry(diff, Map.entry(x-1, y)));
                }
            }
            if(x+1 < m) {
                int diff = Math.max(wt, Math.abs(heights[x][y] - heights[x+1][y]));
                if(diff < result[x+1][y]) {
                    result[x+1][y] = diff;
                    pq.add(Map.entry(diff, Map.entry(x+1, y)));
                }
            }
            if(y-1 >= 0) {
                int diff = Math.max(wt, Math.abs(heights[x][y] - heights[x][y-1]));
                if(diff < result[x][y-1]) {
                    result[x][y-1] = diff;
                    pq.add(Map.entry(diff, Map.entry(x, y-1)));
                }
            }
            if(y+1 < n) {
                int diff = Math.max(wt, Math.abs(heights[x][y] - heights[x][y+1]));
                if(diff < result[x][y+1]) {
                    result[x][y+1] = diff;
                    pq.add(Map.entry(diff, Map.entry(x, y+1)));
                }
            }
        }
        return result[m-1][n-1] == Integer.MAX_VALUE ? 0 : result[m-1][n-1];
    }
}