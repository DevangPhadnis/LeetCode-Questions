class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        List<List<Map.Entry<Integer, Integer>>> adjanceyList = new ArrayList<>();
        int distance[] = new int[n];
        Arrays.fill(distance, Integer.MAX_VALUE);
        for(int i=0;i<n;i++) {
            adjanceyList.add(new ArrayList<>());
        }

        for(int []flight: flights) {
            int u = flight[0];
            int v = flight[1];
            int price = flight[2];
            adjanceyList.get(u).add(Map.entry(v, price));
        }

        Queue<Map.Entry<Integer, Map.Entry<Integer, Integer>>> q = new LinkedList<>();
        q.add(Map.entry(0, Map.entry(src, 0)));
        distance[src] = 0;

        while(!q.isEmpty()) {
            Map.Entry<Integer, Map.Entry<Integer, Integer>> mp = q.poll();
            int stops = mp.getKey();
            Map.Entry<Integer, Integer> map = mp.getValue();
            int source = map.getKey();
            int price = map.getValue();

            if(stops>k) continue;

            for(Map.Entry<Integer, Integer> adj: adjanceyList.get(source)) {
                int adjVertex = adj.getKey();
                int adjPrice = adj.getValue();
                if(adjPrice + price < distance[adjVertex] && stops<=k) {
                    distance[adjVertex] = adjPrice + price;
                    q.add(Map.entry(stops+1, Map.entry(adjVertex, adjPrice+price)));
                }
            }
        }

        return distance[dst] == Integer.MAX_VALUE ? -1 : distance[dst];
    }
}