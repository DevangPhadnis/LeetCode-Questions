class Solution {
    public void setZeroes(int[][] matrix) {
        HashMap<Integer, Boolean> row = new HashMap<>();
        HashMap<Integer, Boolean> column = new HashMap<>();

        for(int i=0;i<matrix.length;i++) {
            for(int j=0;j<matrix[0].length;j++) {
                if(matrix[i][j] == 0) {
                    row.put(i, true);
                    column.put(j, true);
                }
            }
        }

        for(int i=0;i<matrix.length;i++) {
            for(int j=0;j<matrix[0].length;j++) {
                if(row.getOrDefault(i, false) || column.getOrDefault(j, false)) {
                    matrix[i][j] = 0;
                }
            }
        }
    }
}