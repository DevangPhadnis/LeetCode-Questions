class Solution {
    public int[] findOriginalArray(int[] changed) {
        if(changed.length % 2 != 0) return new int[0];
        int []ans = new int[changed.length /2];
        Arrays.sort(changed);
        HashMap<Integer, Integer> map = new HashMap<>();
        int zeroCount = 0;
        for(int i=0;i<changed.length;i++) {
            int value = map.getOrDefault(changed[i], 0);
            map.put(changed[i], ++value);
        }
        int index = 0;
        for(int i=0;i<changed.length;i++) {
            if(map.get(changed[i]) == 0) continue;

            int doubleNums = 2 * changed[i];
            if(changed[i] == 0) {
                if(map.get(0) < 2) return new int[0];
                map.put(0, map.get(0) -2);
                ans[index++] = 0;
            }
            else if (map.getOrDefault(doubleNums, 0) > 0) {
                map.put(changed[i], map.get(changed[i]) - 1);
                map.put(doubleNums, map.get(doubleNums) - 1);
                ans[index++] = changed[i];
            }
            else {
                return new int[0];
            }
        }

        return index < changed.length / 2 ? new int[0] : ans;
    }
}