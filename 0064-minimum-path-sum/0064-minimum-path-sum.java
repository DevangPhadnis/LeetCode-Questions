class Solution {
    public int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int dp[][] = new int[m+1][n+1];
        for(int[] dpArr: dp) 
            Arrays.fill(dpArr, -1);
        return helper(m, n, grid, dp, 0, 0);
    }

    public int helper(int m, int n, int[][] grid, int dp[][], int row, int column) {
        if(row>=m) return Integer.MAX_VALUE;

        else if(column >=n) return Integer.MAX_VALUE;

        if(row == m-1 && column == n-1) return grid[row][column];

        if(dp[row][column] != -1) return dp[row][column];

        int down = helper(m, n, grid, dp, row + 1, column);

        int right = helper(m, n, grid, dp, row, column+1);
        
        dp[row][column] = grid[row][column] + Math.min(down, right);

        return dp[row][column];
    }
}