class DSU {
    int []parent;
    int []size;

    DSU(int n) {
        parent = new int[n];
        size = new int[n];
        Arrays.fill(size, 1);
        for(int i=0;i<n;i++) {
            parent[i] = i;
        }
    }

    public int findParent(int vertex) {
        if(vertex == parent[vertex]) return vertex;

        return parent[vertex] = findParent(parent[vertex]);
    }

    public void union(int vertex1, int vertex2) {
        int ultimateParentVertex1 = findParent(vertex1);
        int ultimateParentVertex2 = findParent(vertex2);
        if(ultimateParentVertex1 == ultimateParentVertex2) return;
        if(size[ultimateParentVertex1] < size[ultimateParentVertex2]) {
            parent[ultimateParentVertex1] = ultimateParentVertex2;
            size[ultimateParentVertex2]+=size[ultimateParentVertex1];
        }
        else {
            parent[ultimateParentVertex2] = ultimateParentVertex1;
            size[ultimateParentVertex1]+=size[ultimateParentVertex2];
        }
    }
}
class Solution {
    public boolean validPath(int n, int[][] edges, int source, int destination) {
        DSU dsu = new DSU(n);
        for(int[] edge: edges) {
            int a = edge[0];
            int b = edge[1];
            dsu.union(a,b);
        }

        if(dsu.findParent(source) == dsu.findParent(destination)) return true;
        else return false;
    }
}