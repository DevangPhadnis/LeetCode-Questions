class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        List<List<Map.Entry<Integer, Integer>>> adjanceyList = new ArrayList<>();
        int time[] = new int[n+1];
        Arrays.fill(time, Integer.MAX_VALUE);
        for(int i=0;i<=n;i++) {
            adjanceyList.add(new ArrayList<>());
        }

        for(int []adj: times) {
            int u = adj[0];
            int v = adj[1];
            int wt = adj[2];
            adjanceyList.get(u).add(Map.entry(v, wt));
        }

        PriorityQueue<Map.Entry<Integer, Integer>> pq = new PriorityQueue<>(
            Comparator.comparingInt(Map.Entry::getValue));
        
        pq.add(Map.entry(k, 0));
        time[k] = 0;
        while(!pq.isEmpty()) {
            Map.Entry<Integer, Integer> mp = pq.poll();
            int vertex = mp.getKey();
            int wt = mp.getValue();
            for(Map.Entry<Integer, Integer> adj: adjanceyList.get(vertex)) {
                int adjVertex = adj.getKey();
                int adjWt = adj.getValue();
                if((adjWt + wt) < time[adjVertex]) {
                    time[adjVertex] = adjWt+wt;
                    pq.add(Map.entry(adjVertex, (adjWt + wt)));
                }
            }
        }
        int ans = 0;
        for(int i=1;i<=n;i++) {
            if(time[i] == Integer.MAX_VALUE) return -1;
            ans = Math.max(ans, time[i]);
        }
        return ans;
    }
}