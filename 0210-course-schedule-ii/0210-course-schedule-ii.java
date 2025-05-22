class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        ArrayList<Integer> ans = new ArrayList<>();
        List<List<Integer>> adjanceyList = new ArrayList<>();
        Queue<Integer> q = new LinkedList<>();
        int indegree[] = new int[numCourses];
        Arrays.fill(indegree, 0);
        for(int i=0;i<numCourses;i++) {
            adjanceyList.add(new ArrayList<>());
        }

        for(int []prerequisite: prerequisites) {
            int u = prerequisite[1];
            int v = prerequisite[0];
            adjanceyList.get(u).add(v);
        }

        for(int i=0;i<numCourses;i++) {
            for(Integer adj: adjanceyList.get(i)) {
                indegree[adj]++;
            }
        }

        for(int i=0;i<numCourses;i++) {
            if(indegree[i] == 0) {
                q.add(i);
            }
        }

        while(!q.isEmpty()) {
            int val = q.poll();
            ans.add(val);
            for(Integer adj: adjanceyList.get(val)) {
                indegree[adj]--;
                if(indegree[adj] == 0) {
                    q.add(adj);
                }
            }
        }

        return numCourses == ans.size() ? ans.stream().mapToInt(i->i).toArray() : new int[0];
    }
}