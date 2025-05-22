class Solution {
    public int maxProfitAssignment(int[] difficulty, int[] profit, int[] worker) {
        ArrayList<int[]> difficult = new ArrayList<>();
        int ans = 0;
        for(int i=0;i<difficulty.length;i++) {
            difficult.add(new int[]{difficulty[i], profit[i]});
        }

        difficult.sort(Comparator.comparingInt((int[] a) -> a[0]));
        Arrays.sort(worker);

        if(worker[worker.length - 1] < difficult.get(0)[0]) return 0;

        int j = 0;
        int p = 0;

        for(int r=0;r<difficult.size();r++) {
            int[] arr = difficult.get(r);
            if(r>0) {
                arr[1] = Math.max(arr[1], difficult.get(r-1)[1]);
                difficult.set(r, arr);
            }
        }

        for(int i=0;i<worker.length;i++) {
            while(j<difficult.size() && worker[i] >= difficult.get(j)[0]) {
                j++;
            }
            if(j!=0)
            ans = ans + difficult.get(j-1)[1];
        }
        return ans;
    }
}