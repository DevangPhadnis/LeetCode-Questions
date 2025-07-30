class Solution {
    public int maxCount(int[] banned, int n, int maxSum) {
        HashMap<Integer, Boolean> map = new HashMap<>();
        for(int i=0;i<banned.length;i++) {
            map.put(banned[i], true);
        }
        Long sum = 0L;
        int count = 0;
        for(int i=1;i<=n;i++) {
            if(!map.getOrDefault(i, false) && (sum+i) <= Long.valueOf(maxSum)) {
                count++;
                sum+=Long.valueOf(i);
            }
        }

        return count;
    }
}