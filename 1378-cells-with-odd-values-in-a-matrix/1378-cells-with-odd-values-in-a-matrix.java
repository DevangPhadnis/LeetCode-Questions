class Solution {
    public int oddCells(int m, int n, int[][] indices) {
        int arrSize = indices.length;
        int row[] = new int[m];
        int col[] =  new int[n];
        int ans = 0;
        for(int i=0;i<arrSize;i++) {
            row[indices[i][0]]++;
            col[indices[i][1]]++;
        }
        for(int p=0;p<m;p++) {
            for(int q=0;q<n;q++) {
                ans+= (row[p] + col[q]) % 2;
            }
        }
        return ans;  
    }
}