class Solution {
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        int m = heights.length;
        int n = heights[0].length;
        boolean pacific[][] = new boolean[m][n];
        boolean atlantic[][] = new boolean[m][n];
        List<List<Integer>> ans = new ArrayList<>();
        for(int i=0;i<m;i++) {
            dfs(heights, i, 0, heights[i][0], pacific);
            dfs(heights, i, n-1, heights[i][n-1], atlantic);
        }

        for(int i=0;i<n;i++) {
            dfs(heights, 0, i, heights[0][i], pacific);
            dfs(heights, m-1, i, heights[m-1][i], atlantic);
        }

        for(int i=0;i<m;i++) {
            for(int j=0;j<n;j++) {
                if(pacific[i][j] && atlantic[i][j]) ans.add(Arrays.asList(i, j));
            }
        }

        return ans;
    }

    public void dfs(int[][] heights, int i, int j, int prevHeight,
    boolean[][] visited) {
        if(i < 0 || j < 0 || i >= heights.length || j>=heights[0].length 
        || visited[i][j] || heights[i][j] < prevHeight) return;

        visited[i][j] = true;

        dfs(heights, i+1, j, heights[i][j], visited);
        dfs(heights, i-1, j, heights[i][j], visited);
        dfs(heights, i, j+1, heights[i][j], visited);
        dfs(heights, i, j-1, heights[i][j], visited);
    }
}