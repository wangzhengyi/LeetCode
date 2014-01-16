import java.util.Scanner;

public class UniquePathsII {
    public static int res = 0;

    public static int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int btx, bty, edx, edy;

        btx = bty = 0;
        edy = obstacleGrid[0].length - 1;
        edx = obstacleGrid.length - 1;

        if (obstacleGrid == null || obstacleGrid[edx][edy] == 1) {
            return 0;
        }

        res = 0;
        dfsMatrix(btx, bty, edx, edy, obstacleGrid);

        return res;
    }

    public static boolean checkOverBoundary(int x, int y, int edx, int edy) {
        boolean flag = false;

        if (x < 0 || x > edx || y < 0 || y > edy) {
            flag = true;
        }

        return flag;
    }

    public static void dfsMatrix(int btx, int bty, int edx, int edy, int[][] obstacleGrid) {
        if (btx == edx && bty == edy) {
            res += 1;
        } else {
            // go right
            int rx = btx;
            int ry = bty + 1;

            if (!checkOverBoundary(rx, ry, edx, edy) && obstacleGrid[rx][ry] == 0) {
                dfsMatrix(rx, ry, edx, edy, obstacleGrid);
            }

            // go down
            int dx = btx + 1;
            int dy = bty;

            if (!checkOverBoundary(dx, dy, edx, edy) && obstacleGrid[dx][dy] == 0) {
                dfsMatrix(dx, dy, edx, edy, obstacleGrid);
            }
        }
    }

    public static int uniquePathsWithObstaclesII(int[][] obstacleGrid) {
        int i, j, n = obstacleGrid.length, m = obstacleGrid[0].length, dp[][] = new int[n][m];
        
        if (obstacleGrid == null || obstacleGrid[n - 1][m - 1] == 1 || obstacleGrid[0][0] == 1) {
            return 0;
        }
        
        // initial dynamic matrix
        for (i = 0; i < n; i ++) {
            if (obstacleGrid[i][0] == 0) {
                dp[i][0] = 1;
            } else {
                break;
            }
        }
        while (i < n) {
            dp[i][0] = 0;
            i ++;
        }
        
        for (j = 0; j < m; j ++) {
            if (obstacleGrid[0][j] == 0) {
                dp[0][j] = 1;
            } else {
                break;
            }
            
        }
        
        while (j < m) {
            dp[0][j] = 0;
            j ++;
        }
        
        
        // dynamic process
        for ( i = 1; i < n; i ++) {
            for ( j = 1; j < m; j ++) {
                if (obstacleGrid[i][j] == 1) {
                    dp[i][j] = 0;
                } else {
                    dp[i][j] = dp[i][j - 1] + dp[i - 1][j];
                }
            }
        }
        
        return dp[n - 1][m - 1];
    }

    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);

        while (cin.hasNext()) {
            int n = cin.nextInt();
            int m = cin.nextInt();
            int[][] obstacleGrid = new int[n][m];


            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    obstacleGrid[i][j] = cin.nextInt();
                }
            }

            int path = uniquePathsWithObstaclesII(obstacleGrid);

            System.out.println(path);
        }

        cin.close();
    }
}
