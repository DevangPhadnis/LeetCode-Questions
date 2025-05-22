class Solution {
    public int countGoodRectangles(int[][] rectangles) {
        int n = rectangles.length;
        int sq[] = new int[n];
        Integer max = -1;
        int total = 0;
        for(int i=0;i<n;i++) {
            Integer l = rectangles[i][0];
            Integer w = rectangles[i][1];
            int current = l;
            if(l<=w) {
                current = l;
                sq[i] = current;
            }
            else {
                current = w;
                sq[i] = current;
            }
            if(current > max) {
                max = current;
            }
        }
        for(int i=0;i<n;i++) {
            if(sq[i] == max) {
                total+=1;
            }
        }
        return total;
    }
}