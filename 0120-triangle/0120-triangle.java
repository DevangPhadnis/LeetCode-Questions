class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int dp[][] = new int[triangle.size()][triangle.size()];
        for(int[] dpArr: dp)
            Arrays.fill(dpArr, -1);
        return helper(triangle, dp, 0, 0);
    }

    public int helper(List<List<Integer>> triangle, int dp[][], int row, int column) {
        if(row == triangle.size() - 1) return triangle.get(row).get(column);

        if(dp[row][column] != -1) return dp[row][column];

        int down = helper(triangle,dp, row + 1, column);
        int diagonal = helper(triangle,dp, row+1, column+1);

        dp[row][column] = triangle.get(row).get(column) + Math.min(down, diagonal);

        return dp[row][column];
    }
}