class Solution {
    public int[][] merge(int[][] intervals) {
        if(intervals.length == 1) return intervals;
        ArrayList<ArrayList<Integer>> arr = new ArrayList<>();
        Arrays.sort(intervals, new Comparator<int[]>() {
            public int compare(int[] a, int[] b) {
                return a[0] - b[0];
            }
        });
        for(int i=0;i<intervals.length;i++) {
            ArrayList<Integer> interval = new ArrayList<>();
            if(arr.size() == 0) {
                interval.add(intervals[i][0]);
                interval.add(intervals[i][1]);
            }
            else if(intervals[i][0] <= arr.get(arr.size() - 1).get(1)) {
                int start = Math.min(arr.get(arr.size() - 1).get(0), intervals[i][0]);
                int end = Math.max(arr.get(arr.size() - 1).get(1), intervals[i][1]);
                arr.removeLast();
                interval.add(start);
                interval.add(end);
            }
            else {
                interval.add(intervals[i][0]);
                interval.add(intervals[i][1]);
            }

            arr.add(interval);
        }

        int [][] ans = new int[arr.size()][2];
        for(int i=0;i<arr.size();i++) {
            ans[i][0] = arr.get(i).get(0);
            ans[i][1] = arr.get(i).get(1);
        }

        return ans;
    }
}