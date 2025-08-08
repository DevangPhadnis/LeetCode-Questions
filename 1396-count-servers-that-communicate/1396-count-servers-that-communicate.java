class Solution {
    public int countServers(int[][] grid) {
        int rowCount[] = new int[grid.length];
        int colCount[] = new int[grid[0].length];
        int ans = 0;
        for(int i=0;i<grid.length;i++) {
            for(int j=0;j<grid[0].length;j++) {
                if(grid[i][j] == 1) {
                    rowCount[i]++;
                    colCount[j]++;
                }
            }
        }

        for(int i=0;i<grid.length;i++) {
            for(int j=0;j<grid[0].length;j++) {
                if(grid[i][j] == 1 && (rowCount[i] > 1 || colCount[j] > 1)) {
                    ans++;
                }
            }
        }

        return ans;
    }
}