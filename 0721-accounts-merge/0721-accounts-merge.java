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
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        int n = accounts.size();
        DSU dsu = new DSU(n);

        HashMap<String, Integer> map = new HashMap<>();
        for(int i=0;i<n;i++) {
            for(int j=1;j<accounts.get(i).size();j++) {
                if(map.getOrDefault(accounts.get(i).get(j), -1) == -1) {
                    map.put(accounts.get(i).get(j), i);
                }
                else {
                    dsu.union(i, map.get(accounts.get(i).get(j)));
                }
            }
        }

        ArrayList<String>[] mapMail = new ArrayList[n];
        for(int i=0;i<n;i++) {
            mapMail[i] = new ArrayList<String>();
        }

        for(Map.Entry<String, Integer> mp: map.entrySet()) {
            String key = mp.getKey();
            int parent = dsu.findParent(mp.getValue());
            mapMail[parent].add(key);
        }

        List<List<String>> ans = new ArrayList<>();

        for(int i=0;i<n;i++) {
            if(mapMail[i].size() == 0) continue;
            Collections.sort(mapMail[i]);
            List<String> temp = new ArrayList<>();
            temp.add(accounts.get(i).get(0));
            for(String name: mapMail[i]) {
                temp.add(name);
            }
            ans.add(temp);
        }
        return ans;
    }
}