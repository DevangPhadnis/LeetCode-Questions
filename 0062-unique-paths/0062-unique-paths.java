class Solution {
    public int uniquePaths(int m, int n) {
        int dp[][] = new int[m+1][n+1];
        for(int[] dpArr: dp)
            Arrays.fill(dpArr, -1);
        return helper(m, n, dp, 0, 0);
    }

    public int helper(int m, int n, int dp[][], int row, int column) {
        if(column == n-1 && row == m-1) return 1;

        if(row >= m) return 0;

        else if(column >=n) return 0;

        if(dp[row][column] != -1) return dp[row][column];

        int down = helper(m, n, dp, row + 1, column);
        int top = helper(m, n, dp, row, column + 1);
        
        dp[row][column] = down + top;

        return dp[row][column];
    }
}