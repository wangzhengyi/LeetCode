import java.util.Scanner;


public class WordSearch {
    public static boolean exist(char[][] board, String word) {
        if (board == null || board.length == 0 || word == null || word.length() == 0) {
            return false;
        }

        boolean[][] visit = new boolean[board.length][board[0].length];

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (dfs(visit, board, word, 0, i, j)) {
                    return true;
                }
            }
        }

        return false;
    }

    public static boolean dfs(boolean[][] visit, char[][] board, String word, int cur, int x, int y) {
        if (board[x][y] != word.charAt(cur) || visit[x][y]) {
            return false;
        }

        visit[x][y] = true;

        if (cur == word.length() - 1) {
            return true;
        }

        if (x - 1 >= 0 && dfs(visit, board, word, cur + 1, x - 1, y)) {
            return true;
        }

        if (x + 1 < board.length && dfs(visit, board, word, cur + 1, x + 1, y)) {
            return true;
        }

        if (y - 1 >= 0 && dfs(visit, board, word, cur + 1, x, y - 1)) {
            return true;
        }

        if (y + 1 < board[0].length && dfs(visit, board, word, cur + 1, x, y + 1)) {
            return true;
        }

        visit[x][y] = false;

        return false;
    }

    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);
        
        // just a test
        while (cin.hasNext()) {
            int row = Integer.parseInt(cin.nextLine());
            int col = Integer.parseInt(cin.nextLine());
            String str = cin.nextLine();
            char[][] board = new char[row][col];

            for (int i = 0; i < row; i++) {
                for (int j = 0; j < col; j++) {
                    board[i][j] = str.charAt(i * col + j);
                }
            }

            String word = cin.nextLine();

            boolean flag = exist(board, word);

            System.out.println(flag);
        }

        cin.close();
    }
}
