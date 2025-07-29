class Solution {
    public int findMinArrowShots(int[][] points) {
        if(points.length == 1) return 1;
        Arrays.sort(points, new Comparator<int[]>() {
            public int compare(int[] a, int[] b) {
                return Integer.compare(a[1], b[1]);
            }
        });

        int count = 1;
        Long arrowPos = Long.valueOf(points[0][1]);
        for(int i=1;i<points.length;i++) {
            Long currentStartPoint = Long.valueOf(points[i][0]);
            if(currentStartPoint > arrowPos) {
                count++;
                arrowPos = Long.valueOf(points[i][1]);
            }
            else continue;
        }
        return count;
    }
}