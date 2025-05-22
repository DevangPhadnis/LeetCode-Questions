class Solution {
    public int minimumJumps(int[] forbidden, int a, int b, int x) {
        HashMap<Integer, Boolean> map = new HashMap<>();
        int maxForbidden = Integer.MIN_VALUE;
        for(int i=0;i<forbidden.length;i++) {
            map.put(forbidden[i], true);
            maxForbidden = Math.max(maxForbidden, forbidden[i]);
        }

        return helper(map, a, b, 0, x, 0, false, maxForbidden, new HashSet<>());
    }

    public int helper(HashMap<Integer, Boolean> map, int a, int b, int jumps, int x,
     int index, Boolean flag, int maxForbidden,Set<String> visited) {
        if(index > 6000 || index < 0) return -1;

        if(map.getOrDefault(index, false)) return -1;

        if(index == x) return jumps;

        String key = index + " " + flag;

        if(visited.contains(key)) return -1;

        visited.add(key);
        
        int firstJumps = helper(map, a, b, jumps + 1, x, index+a, false, maxForbidden, visited);

        int secondJumps = -1;
        if(!flag) {
            secondJumps = helper(map, a, b, jumps + 1, x, index-b, true, maxForbidden, visited);
        }

        if(firstJumps == -1) return secondJumps;

        else if(secondJumps == -1) return firstJumps;

        else return Math.min(secondJumps, firstJumps);
    }
}