import java.util.ArrayDeque;
import java.util.Scanner;

public class SurroundedRegions {
	private static class BoardPoint {
		private int x, y;

		public BoardPoint(int x, int y) {
			this.x = x;
			this.y = y;
		}

		public int getX() {
			return x;
		}

		public int getY() {
			return y;
		}
	}

	private static int[][] directions = { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };

	public static void solve(char[][] board) {
		int row = board.length;
		if (row < 2) {
			return;
		}

		int column = board[0].length;
		if (column < 2) {
			return;
		}

		for (int j = 0; j < board[0].length; j++) {
			if (board[0][j] == 'O') {
				bfsBoard(board, 0, j, row, column);
			}
		}

		for (int i = 1; i < board.length; i++) {
			if (board[i][column - 1] == 'O') {
				bfsBoard(board, i, column - 1, row, column);
			}
		}

		for (int j = column - 2; j >= 0; j--) {
			if (board[row - 1][j] == 'O') {
				bfsBoard(board, row - 1, j, row, column);
			}
		}

		for (int i = row - 2; i >= 0; i--) {
			if (board[i][0] == 'O') {
				bfsBoard(board, i, 0, row, column);
			}
		}

		for (int i = 0; i < row; i++) {
			for (int j = 0; j < column; j++) {
				board[i][j] = board[i][j] == 'K' ? 'O' : 'X';
			}
		}
	}

	private static void bfsBoard(char[][] board, int x, int y, int row, int col) {
		ArrayDeque<BoardPoint> queue = new ArrayDeque<BoardPoint>();
		queue.push(new BoardPoint(x, y));
		while (!queue.isEmpty()) {
			BoardPoint point = queue.poll();
			board[point.getX()][point.getY()] = 'K';

			for (int i = 0; i < directions.length; i++) {
				int new_x = point.getX() + directions[i][0];
				int new_y = point.getY() + directions[i][1];

				if (new_x >= 0 && new_x < row && new_y >= 0 && new_y < col && board[new_x][new_y] == 'O') {
					queue.push(new BoardPoint(new_x, new_y));
				}
			}
		}
	}

	public static void main(String[] args) {
		Scanner cin = new Scanner(System.in);

		while (cin.hasNext()) {
			int row = cin.nextInt();
			char[][] board = new char[row][];

			for (int i = 0; i < row; i++) {
				String str = cin.next();
				board[i] = new char[str.length()];
				for (int j = 0; j < board[i].length; j++) {
					board[i][j] = str.charAt(j);
				}
			}

			solve(board);

			for (int i = 0; i < board.length; i++) {
				for (int j = 0; j < board[0].length; j++) {
					System.out.printf("%c ", board[i][j]);
				}
				System.out.println();
			}
		}

		cin.close();
	}
}
