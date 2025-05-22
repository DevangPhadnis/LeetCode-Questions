class DSU {
    int []parent;
    int []size;

    DSU(int n) {
        parent = new int[n+1];
        size = new int[n+1];
        Arrays.fill(size, 1);
        for(int i=1;i<=n;i++) {
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
    public int[] findRedundantConnection(int[][] edges) {
        int n = edges.length;

        DSU dsu = new DSU(n);

        for(int[] edge: edges) {
            int u = edge[0];
            int v = edge[1];

            if(dsu.findParent(u) == dsu.findParent(v)) return edge;

            dsu.union(u,v);
        }
        return new int[2];
    }
}