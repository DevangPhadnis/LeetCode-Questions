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
    public String smallestEquivalentString(String s1, String s2, String baseStr) {
        DSU dsu = new DSU();

        for(int i=0;i<s1.length();i++) {
            int u = s1.charAt(i) - 'a';
            int v = s2.charAt(i) - 'a';
            dsu.union(u, v);
        }

        StringBuilder sb = new StringBuilder();
        for(char ch: baseStr.toCharArray()) {
            int root = dsu.findParent(ch - 'a');
            sb.append((char) (root + 'a'));
        }

        return sb.toString();
    }
}