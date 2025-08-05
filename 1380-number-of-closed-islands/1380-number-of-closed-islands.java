class Solution {
    public int closedIsland(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int count = 0;

        for(int i=0;i<n;i++) {
            dfs(grid, i, 0);
            dfs(grid, i, m-1);
        }

        for(int j=0;j<m;j++) {
            dfs(grid, 0, j);
            dfs(grid, n-1, j);
        }

        for(int i=0;i<n;i++) {
            for(int j=0;j<m;j++) {
                if(grid[i][j] == 0) {
                    dfs(grid, i, j);
                    count++;
                }
            }
        }
        return count;
    }

    public void dfs(int[][] grid, int i, int j) {
        if(i < 0 || i >= grid.length || j < 0 || j>=grid[0].length || grid[i][j] != 0)
            return;
        grid[i][j] = 1;

        dfs(grid, i-1, j);
        dfs(grid, i+1, j);
        dfs(grid, i, j-1);
        dfs(grid, i, j+1);
    }
}