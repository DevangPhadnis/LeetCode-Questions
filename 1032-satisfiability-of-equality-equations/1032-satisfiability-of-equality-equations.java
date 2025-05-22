class DSU {
    int []parent;
    int []size;

    DSU() {
        parent = new int[26];
        size = new int[26];
        Arrays.fill(size, 1);
        for(int i=0;i<26;i++) {
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

        if(ultimateParentVertex1 < ultimateParentVertex2) {
            parent[ultimateParentVertex2] = ultimateParentVertex1;
        }
        else {
            parent[ultimateParentVertex1] = ultimateParentVertex2;
        }
    }
}

class Solution {
    public boolean equationsPossible(String[] equations) {
        DSU dsu = new DSU();
        for(String eq: equations) {
            if(eq.charAt(1) == '=') {
                int u = eq.charAt(0) - 'a';
                int v = eq.charAt(3) - 'a';
                dsu.union(u, v);
            }
        }

        for(String eq: equations) {
            if(eq.charAt(1) == '!') {
                int u = eq.charAt(0) - 'a';
                int v = eq.charAt(3) - 'a';
                if(dsu.findParent(u) == dsu.findParent(v)) return false;
            }
        }

        return true;
    }
}