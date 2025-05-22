class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        int count = Integer.MIN_VALUE;
        for(int i=0;i<grid.length;i++) {
            for(int j=0;j<grid[0].length;j++) {
                if(grid[i][j] == 1) {
                    int area = bfs(i, j, grid);
                    count = Math.max(count, area);
                }
            }
        }
        return count == Integer.MIN_VALUE ? 0 : count;
    }

    public int bfs(int i, int j, int[][] grid) {
        int rowLength = grid.length;
        int colLength = grid[0].length;
        Queue<Map.Entry<Integer, Integer>> q = new LinkedList<>();
        q.add(Map.entry(i, j));
        grid[i][j] = 0;
        int area = 1;
        while(!q.isEmpty()) {
            Map.Entry<Integer, Integer> node = q.poll();
            int row = node.getKey();
            int column = node.getValue();
            if(row+1 < rowLength && grid[row + 1][column] == 1) {
                area++;
                grid[row+1][column] = 0;
                q.add(Map.entry(row+1, column));
            }
            if(row-1 >= 0 && grid[row - 1][column] == 1) {
                area++;
                grid[row-1][column] = 0;
                q.add(Map.entry(row-1, column));
            }
            if(column+1 < colLength && grid[row][column+1] == 1) {
                area++;
                grid[row][column+1] = 0;
                q.add(Map.entry(row, column + 1));
            }
            if(column -1 >= 0 && grid[row][column-1] == 1) {
                area++;
                grid[row][column-1] = 0;
                q.add(Map.entry(row, column-1));
            }
        }

        return area;
    }
}