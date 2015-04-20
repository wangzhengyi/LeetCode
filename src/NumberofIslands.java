import java.util.ArrayDeque;
import java.util.Deque;

public class NumberofIslands {

	public int numIslands(char[][] grid) {
		int res = 0;

		if (grid == null || grid.length == 0 || grid[0].length == 0) {
			return 0;
		}

		int row = grid.length;
		int col = grid[0].length;

		// 初始化visited数组
		boolean[][] visited = new boolean[row][col];
		int[][] directions = { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };
		Deque<Integer> queue = new ArrayDeque<Integer>();

		for (int i = 0; i < row; i++) {
			for (int j = 0; j < col; j++) {
				if (grid[i][j] == '0' || visited[i][j]) {
					continue;
				}

				int loc = i * col + j;
				queue.add(loc);
				res += 1;
				while (!queue.isEmpty()) {
					loc = queue.poll();
					int tpx = loc / col;
					int tpy = loc % col;
					if (visited[tpx][tpy]) {
						continue;
					}
					
					visited[tpx][tpy] = true;

					for (int k = 0; k < 4; k++) {
						int x = tpx + directions[k][0];
						int y = tpy + directions[k][1];

						if (x >= 0 && x < row && y >= 0 && y < col && grid[x][y] == '1') {
							queue.add(x * col + y);
						}
					}
				}
			}
		}

		return res;
	}
}
