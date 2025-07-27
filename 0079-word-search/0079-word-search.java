class Solution {
    public boolean exist(char[][] board, String word) {
        if(word.length() > (board.length * board[0].length)) return false;

        for(int i=0;i<board.length;i++) {
            for(int j=0;j<board[0].length;j++) {
                if(board[i][j] == word.charAt(0))
                {
                    if(helper(board, i, j, word, 0)) return true;
                }
            }
        }
        return false;
    }

    public boolean helper(char[][] board, int i, int j, String word, int idx) {
        if(idx == word.length()) return true;
        else if(i < 0 || i >= board.length || j < 0 || j >= board[0].length) return false;
        else if(board[i][j] != word.charAt(idx)) return false;

        char temp = board[i][j];
        board[i][j] = '#';

        boolean result = helper(board, i+1, j, word, idx+1) || 
                         helper(board, i-1, j, word, idx+1) ||
                         helper(board, i, j+1, word, idx+1) ||
                         helper(board, i, j-1, word, idx+1);
        board[i][j] = temp;
        return result;
    }
}