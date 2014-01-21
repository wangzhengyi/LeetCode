import java.util.HashSet;


public class ValidSudoku {
    public static boolean isValidSudoku(char[][] board) {
        HashSet<Character> rowSet = new HashSet<Character>();
        HashSet<Character> colSet = new HashSet<Character>();
        HashSet<Character> matrixSet = new HashSet<Character>();

        // check row valid
        for (int i = 0; i < 9; i++) {
            rowSet.clear();
            for (int j = 0; j < 9; j++) {
                if (board[i][j] == '.') {
                    continue;
                }
                if (rowSet.contains(board[i][j])) {
                    return false;
                } else {
                    rowSet.add(board[i][j]);
                }
            }
        }

        // check column valid
        for (int j = 0; j < 9; j++) {
            colSet.clear();
            for (int i = 0; i < 9; i++) {
                if (board[i][j] == '.') {
                    continue;
                }
                if (colSet.contains(board[i][j])) {
                    return false;
                } else {
                    colSet.add(board[i][j]);
                }
            }
        }

        // check small matrix valid
        for (int i = 0; i < 9; i += 3) {
            for (int j = 0; j < 9; j += 3) {
                matrixSet.clear();
                for (int k = 0; k < 3; k++) {
                    for (int h = 0; h < 3; h++) {
                        if (board[k + i][h + j] == '.') {
                            continue;
                        }
                        if (matrixSet.contains(board[k + i][h + j])) {
                            return false;
                        } else {
                            matrixSet.add(board[k + i][h + j]);
                        }
                    }
                }
            }
        }

        return true;
    }
}
