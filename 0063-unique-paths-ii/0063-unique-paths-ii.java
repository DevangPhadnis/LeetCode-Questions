class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        int dp[][] = new int[m+1][n+1];
        for(int[] dpArr: dp)
            Arrays.fill(dpArr, -1);
        return helper(m, n,obstacleGrid, dp, 0, 0);
    }

    public int helper(int m, int n, int obstacle[][], int dp[][], int row, int column) {
        if(row >= m) return 0;

        else if(column >=n) return 0;

        else if(obstacle[row][column] == 1) return 0;

        if(column == n-1 && row == m-1) return 1;

        if(dp[row][column] != -1) return dp[row][column];

        int down = helper(m, n, obstacle, dp, row + 1, column);
        int top = helper(m, n, obstacle, dp, row, column + 1);
        
        dp[row][column] = down + top;

        return dp[row][column];
    }
}