import java.util.Scanner;


public class RotateImage {
    public static void main(String[] args) {
        int i, j, n, matrix[][];
        Scanner cin = new Scanner(System.in);
        
        while (cin.hasNext()) {
            n = cin.nextInt();
            matrix = new int[n][n];
            
            for (i = 0; i < n; i ++) {
                for (j = 0; j < n; j ++) {
                    matrix[i][j] = cin.nextInt();
                }
            }
            
            // 打印矩阵
            printMatrix(matrix);
            
            // 转换矩阵
            rotate(matrix);
            
            // 打印矩阵
            printMatrix(matrix);
        }
        
        cin.close();
    }
    
    public static void printMatrix(int[][] matrix) {
        for (int i = 0; i < matrix.length; i ++) {
            for (int j = 0; j < matrix[0].length; j ++) {
                System.out.printf("%d ", matrix[i][j]);
            }
            System.out.println();
        }
    }
    
    public static void rotate(int[][] matrix) {
        int i, j, n = matrix.length, tmp[][] = new int[n][n];
        
        for (i = 0; i < n; i ++) {
            for (j = 0; j < n; j ++) {
                tmp[j][n - 1 - i] = matrix[i][j];
            }
        }
        
        for (i = 0; i < n; i ++) {
            for (j = 0; j < n; j ++) {
                matrix[i][j] = tmp[i][j];
            }
        }
    }
}
