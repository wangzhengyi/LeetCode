import java.util.Scanner;


public class SpiralMatrixII {
    public static void main(String args[]) {
        int n, res[][];
        Scanner cin = new Scanner(System.in);

        while (cin.hasNext()) {
            n = cin.nextInt();
            res = generateMatrix(n);

            for (int i = 0; i < res.length; i++) {
                for (int j = 0; j < res[0].length; j++) {
                    System.out.printf("%d ", res[i][j]);
                }
                System.out.println();
            }
        }

        cin.close();
    }

    public static int[][] generateMatrix(int n) {
        int minX, minY, maxX, maxY, cnt, bt, res[][] = new int[n][n];

        if (n == 0) {
            return res;
        }
        
        // initial variable
        maxX = maxY = n - 1;
        minX = minY = 0;
        bt = 1;

        for (cnt = 0; cnt <= (n - 1) / 2; cnt++) { // loop count
            int row = minX;
            int col = minY;
            res[row][col] = bt++;
            
            if (minX >= maxX && minY >= maxY) {
                break;
            }

            for (col += 1; col <= maxY; col ++) {
                res[row][col] = bt++;
                if (col == maxY) break;
            }

            for (row += 1; row <= maxX; row++) {
                res[row][col] = bt++;
                if (row == maxX) break;
            }

            for (col -= 1; col >= minY; col--) {
                res[row][col] = bt++;
                if (col == minY) break;
            }

            for (row -= 1; row > minX; row--) {
                res[row][col] = bt++;
                if (row == minX + 1) break;
            }

            minX++;
            minY++;
            maxX--;
            maxY--;
        }

        return res;
    }
}
