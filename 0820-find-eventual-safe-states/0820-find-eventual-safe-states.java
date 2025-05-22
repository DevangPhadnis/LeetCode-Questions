class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        int n = graph.length;
        List<List<Integer>> adjanceyList = new ArrayList<>();
        int indegree[] = new int[n];
        List<Integer> safeNodes = new ArrayList<>();
        Queue<Integer> q = new LinkedList<>();
        for(int i=0;i<n;i++) {
            adjanceyList.add(new ArrayList<>());
        }

        for(int u=0;u<n;u++) {
            for(int v: graph[u]) {
                adjanceyList.get(v).add(u);
            }
        }

        for(int i=0;i<n;i++) {
            for(Integer adj: adjanceyList.get(i)) {
                indegree[adj]++;
            }
        }

        for(int i=0;i<n;i++) {
            if(indegree[i] == 0) {
                q.add(i);
            }
        }

        while(!q.isEmpty()) {
            Integer val = q.poll();
            safeNodes.add(val);
            for(Integer adj: adjanceyList.get(val)) {
                indegree[adj]--;
                if(indegree[adj] == 0) {
                    q.add(adj);
                }
            }
        }
        Collections.sort(safeNodes);
        return safeNodes;
    }
}