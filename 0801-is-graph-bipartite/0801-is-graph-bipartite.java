class Solution {
    public boolean isBipartite(int[][] graph) {
        int []visited = new int[graph.length];
        Arrays.fill(visited, -1);
        for(int i=0;i<visited.length;i++) {
            if(visited[i] == -1) {
                if(!checkBiPartite(visited, graph, i)) return false;
            }
        }
        return true;
    }

    public boolean checkBiPartite(int[] visited, int[][] graph, int src) {
        Queue<Integer> q = new LinkedList<>();
        q.add(src);
        visited[src] = 0;
        while(!q.isEmpty()) {
            int value = q.poll();
            for(int j=0;j<graph[value].length;j++) {
                if(visited[graph[value][j]] == -1) {
                    visited[graph[value][j]] = 1-visited[value];
                    q.add(graph[value][j]);
                }
                else if(visited[graph[value][j]] == visited[value]) return false;
            }
        }
        return true;
    }
}