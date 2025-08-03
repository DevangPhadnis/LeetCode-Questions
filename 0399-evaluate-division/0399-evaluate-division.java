class Solution {
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        Map<String, Map<String, Double>> graph = new HashMap<>();
        for(int i=0;i<equations.size();i++) {
            String numerator = equations.get(i).get(0);
            String denominator = equations.get(i).get(1);
            Double value = values[i];

            graph.putIfAbsent(numerator, new HashMap<>());
            graph.putIfAbsent(denominator, new HashMap<>());

            graph.get(numerator).put(denominator, value);
            graph.get(denominator).put(numerator, 1.0/value);
        }

        double[] ans = new double[queries.size()];

        for(int i=0;i<queries.size();i++) {
            String start = queries.get(i).get(0);
            String end = queries.get(i).get(1);

            if(!graph.containsKey(start) || !graph.containsKey(end)) {
                ans[i] = -1.0;
            }
            else {
                ans[i] = bfs(graph, start, end);
            }
        }

        return ans;
    }

    public double bfs(Map<String, Map<String, Double>> graph, String start
    , String end) {
        Queue<String> queue = new LinkedList<>();
        Map<String, Double> visited = new HashMap<>();

        queue.add(start);
        visited.put(start, 1.0);

        while(!queue.isEmpty()) {
            String node = queue.poll();
            if(node.equals(end)) return visited.get(node);

            for(Map.Entry<String, Double> neighbour: graph.get(node).entrySet()) {
                String nextNode = neighbour.getKey();
                Double newValue = visited.get(node) * neighbour.getValue();

                if(!visited.containsKey(nextNode)) {
                    visited.put(nextNode, newValue);
                    queue.add(nextNode);
                }
            }
        }
        return -1.0;
    }
}