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
    public int makeConnected(int n, int[][] connections) {

        if(connections.length < n-1) return -1;

        DSU dsu = new DSU(n);
        int extraEdges = 0;
        int component = 0;

        for(int[] connection: connections) {
            int a = connection[0];
            int b = connection[1];
            if(dsu.findParent(a) == dsu.findParent(b)) {
                extraEdges++;
            }
            else {
                dsu.union(a,b);
            }
        }

        for(int i=0;i<n;i++) {
            if(dsu.findParent(i) == i) component++;
        }

        int neededEdges = component - 1;
        return extraEdges >= neededEdges ? neededEdges : -1;
    }
}