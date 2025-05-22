class Solution {
    public double maxProbability(int n, int[][] edges, double[] succProb, int start_node, int end_node) {
        int edgesSize = edges.length;
        List<List<Map.Entry<Integer, Double>>> adjanceyList = new ArrayList<>();
        double probability[] = new double[n];
        Arrays.fill(probability, 0);
        for(int i=0;i<n;i++) {
            adjanceyList.add(new ArrayList<>());
        }
        for(int i=0;i<edgesSize;i++) {
            int u = edges[i][0];
            int v = edges[i][1];
            double wt = succProb[i];
            adjanceyList.get(u).add(Map.entry(v, wt));
            adjanceyList.get(v).add(Map.entry(u, wt));
        }


        PriorityQueue<Map.Entry<Integer, Double>> pq = new PriorityQueue<>(
            Comparator.comparingDouble(Map.Entry<Integer, Double>::getValue).reversed());
        
        pq.add(Map.entry(start_node, 1.0000));
        probability[start_node] = 1;
        while(!pq.isEmpty()) {
            Map.Entry<Integer, Double> mp = pq.poll();
            int vertex = mp.getKey();
            double wt = mp.getValue();
            for(Map.Entry<Integer, Double> adj: adjanceyList.get(vertex)) {
                int adjVertex = adj.getKey();
                double adjWt = adj.getValue();
                if((adjWt * wt) > probability[adjVertex]) {
                    probability[adjVertex] = adjWt*wt;
                    pq.add(Map.entry(adjVertex, (adjWt * wt)));
                }
            }
        }
        return probability[end_node] == Double.MAX_VALUE ? 0 : probability[end_node];
    }
}