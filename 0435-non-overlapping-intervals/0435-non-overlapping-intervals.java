class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        if(intervals.length <= 1) return 0;
        Arrays.sort(intervals, new Comparator<int[]>() {
            public int compare(int[] a, int[] b) {
                return a[1] - b[1];
            }
        });
        int nonOverlapCount = 1;
        int lastEnd = intervals[0][1];
        for(int i=1;i<intervals.length;i++) {
            int currentStart = intervals[i][0];
            if(currentStart>=lastEnd) {
                nonOverlapCount++;
                lastEnd = intervals[i][1];
            }
            else {
                continue;
            }
        }
        return intervals.length - nonOverlapCount;
    }
}