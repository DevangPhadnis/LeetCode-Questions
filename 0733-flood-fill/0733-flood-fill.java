class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int ans[][] = new int[image.length][image[0].length];
        for(int[] answer: ans) {
            Arrays.fill(answer, -1);
        }
        int rowLength = image.length;
        int colLength = image[0].length;
        
        Queue<Map.Entry<Integer, Integer>> q = new LinkedList<>();
        q.add(Map.entry(sr, sc));
        ans[sr][sc] = color;
        int originalColor = image[sr][sc];
        if(originalColor == color) return image;
        image[sr][sc] = -1;

        while(!q.isEmpty()) {
            Map.Entry<Integer, Integer> mp = q.poll();
            int row = mp.getKey();
            int column = mp.getValue();

            if(row+1 < rowLength && image[row + 1][column] == originalColor) {
                image[row + 1][column] = -1;
                ans[row+1][column] = color;
                q.add(Map.entry(row+1, column));
            }
            if(row-1 >= 0 && image[row - 1][column] == originalColor) {
                image[row - 1][column] = -1;
                ans[row-1][column] = color;
                q.add(Map.entry(row-1, column));
            }
            if(column+1 < colLength && image[row][column+1] == originalColor) {
                image[row][column+1] = -1;
                ans[row][column+1] = color;
                q.add(Map.entry(row, column + 1));
            }
            if(column -1 >= 0 && image[row][column-1] == originalColor) {
                image[row][column-1] = -1;
                ans[row][column-1] = color;
                q.add(Map.entry(row, column-1));
            }
        }

        for(int i=0;i<rowLength;i++) {
            for(int j=0;j<colLength;j++) {
                if(ans[i][j] == -1) ans[i][j] = image[i][j];
            }
        }

        return ans;
    }
}