class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<List<Integer>> adjanceyList = new ArrayList<>();
        int []indegree = new int[numCourses];
        Queue<Integer> q = new LinkedList<>();
        List<Integer> topo = new ArrayList<>();
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
            for(Integer adj: adjanceyList.get(i))  {
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
            topo.add(val);
            for(Integer adj: adjanceyList.get(val)) {
                indegree[adj]--;
                if(indegree[adj] == 0) {
                    q.add(adj);
                }
            }
        }

        return topo.size() == numCourses ? true : false;
    }
}