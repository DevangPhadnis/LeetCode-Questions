class Solution {
    public void solveSudoku(char[][] board) {
        helper(board, 0, 0);
    }
    public boolean helper(char[][] board, int row, int col) {
        if(col == 9) {
            row++;
            col = 0;
        }
        if(row == 9) return true;
        if(board[row][col] == '.') {
            for(char val = '1'; val <= '9'; val++) {
                if(isSafe(board, val, row, col)) {
                    board[row][col] = val;
                    if(helper(board, row, col+1)) return true;
                    board[row][col] = '.';
                }
            }
            return false;
        }
        else {
            return helper(board, row, col + 1);
        }
    }
    public boolean isSafe(char[][] board, char val, int row, int col) {
        for(int column = 0; column < 9; column++) {
            if(board[row][column] == val) return false;
        }
        for(int r = 0; r < 9; r++) {
            if(board[r][col] == val) return false;
        }
        int startIndex = (row / 3) * 3;
        int startColIndex = (col / 3) * 3;
        for(int i = 0;i<3;i++) {
            for(int j = 0;j<3;j++) {
                if(board[i+startIndex][j+startColIndex] == val) return false;
            }
        }
        return true;
    }
}