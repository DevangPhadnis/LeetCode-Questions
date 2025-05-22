class Solution {
    public int findCircleNum(int[][] isConnected) {
        int visited[] = new int[isConnected.length];
        Arrays.fill(visited, 0);
        int count = 0;
        for(int i=0;i<isConnected.length;i++) {
            if(visited[i] == 0) {
                count++;
                bfs(isConnected, visited, i);
            }
        }
        return count;
    }

    public void bfs(int[][] adj, int[] visited, int node) {
        // code here
        Queue<Integer> q = new LinkedList<>();
        q.add(node);
        visited[node] = 1;
        while(!q.isEmpty()) {
            int value = q.poll();
            for(int j=0;j<adj.length;j++) {
                if(adj[value][j] == 1 && visited[j] == 0) {
                    visited[j] = 1;
                    q.add(j);
                }
            }
        }
    }
}