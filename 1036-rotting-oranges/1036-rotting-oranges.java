class Solution {
    public int orangesRotting(int[][] grid) {
        Queue<Map.Entry<Integer, Integer>> q = new LinkedList<>();
        int fresh = 0;
        int rowLength = grid.length;
        int colLength = grid[0].length;
        for(int i=0;i<grid.length;i++) {
            for(int j=0;j<grid[0].length;j++) {
                if(grid[i][j] == 2) {
                    q.add(Map.entry(i, j));
                }
                else if(grid[i][j] == 1) {
                    fresh++;
                }
            }
        }
        int minute = 0;
        while(!q.isEmpty()) {
            int size = q.size();
            for(int i=0;i<size;i++) {
                Map.Entry<Integer, Integer> index = q.poll();
                int row = index.getKey();
                int col = index.getValue();
                if(row+1 < rowLength && grid[row+1][col] == 1) {
                    grid[row+1][col] = 2;
                    fresh--;
                    q.add(Map.entry(row+1, col));
                }
                if(row-1 >= 0 && grid[row-1][col] == 1) {
                    grid[row-1][col] = 2;
                    fresh--;
                    q.add(Map.entry(row-1, col));
                }
                if(col+1 < colLength && grid[row][col+1] == 1) {
                    grid[row][col+1] = 2;
                    fresh--;
                    q.add(Map.entry(row, col+1));
                }
                if(col-1 >= 0 && grid[row][col-1] == 1) {
                    grid[row][col-1] = 2;
                    fresh--;
                    q.add(Map.entry(row, col-1));
                }
            }
            minute++;
        }

        return fresh == 0 ? minute == 0 ? minute : minute - 1 : -1;
    }
}