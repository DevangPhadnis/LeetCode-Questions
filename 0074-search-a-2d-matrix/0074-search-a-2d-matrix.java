class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int left = 0, right = matrix.length * matrix[0].length - 1;
        while(left <= right) {
            int mid = (left+right)/2;
            int row = mid/matrix[0].length;
            int col = mid%matrix[0].length;
            if(matrix[row][col] == target) return true;
            else if(matrix[row][col] < target) left = mid+1;
            else right = mid - 1;
        }
        return false;
    }
}