import java.util.ArrayList;


public class SudokuSolver {
    public void solveSudoku(char[][] board) {
        ArrayList<Integer> emptyList = new ArrayList<Integer>();

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] == '.') {
                    emptyList.add(i * 9 + j);
                }
            }
        }

        dfsSudoku(board, emptyList, 0, emptyList.size());
    }

    public boolean dfsSudoku(char[][] board, ArrayList<Integer> emptyList, int cur, int len) {
        if (cur == len) {
            return true;
        } else {
            int emptyNum = emptyList.get(cur);
            int row = emptyNum / 9;
            int col = emptyNum % 9;

            for (int i = 1; i <= 9; i++) {
                char ch = (char) (i + '0');
                if (isValid(board, row, col, ch)) {
                    board[row][col] = ch;
                    if (dfsSudoku(board, emptyList, cur + 1, len)) {
                        return true;
                    }
                    board[row][col] = '.';
                }
            }
            return false;
        }
    }

    public boolean isValid(char[][] board, int row, int col, char ch) {
        for (int i = 0; i < 9; i++) {
            if (board[row][i] == ch) {
                return false;
            }

            if (board[i][col] == ch) {
                return false;
            }

            int mRow = 3 * (row / 3) + i / 3;
            int mCol = 3 * (col / 3) + i % 3;
            if (board[mRow][mCol] == ch) {
                return false;
            }
        }

        return true;
    }
}
