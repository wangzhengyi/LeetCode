import java.util.Scanner;


public class SetMatrixZeros {
    public static void main(String[] args) {
        int i, j, n, m, matrix[][];
        Scanner cin = new Scanner(System.in);
        
        while (cin.hasNext()) {
            m = cin.nextInt();
            n = cin.nextInt();
            matrix = new int[m][n];
            
            for (i = 0; i < m; i ++) {
                for (j = 0; j < n; j ++) {
                    matrix[i][j] = cin.nextInt();
                }
            }
            
            setZeros(matrix);
            
            printMatrix(matrix);
        }
        
        cin.close();
    }
    
    
    public static void printMatrix(int[][] matrix) {
        int i, j, m = matrix.length, n = matrix[0].length;
        
        for (i = 0; i < m; i ++) {
            for (j = 0; j < n; j ++) {
                System.out.printf("%d ", matrix[i][j]);
            }
            System.out.println();
        }
    }
    
    public static void setZeros(int[][] matrix) {
        int i, j, n, m;
        boolean zeroCol = false, zeroRow = false;
        
        m = matrix.length;
        n = matrix[0].length;
        
        // should first row or first column be zero
        for (i = 0; i < n; i ++) {
            if (matrix[0][i] == 0) {
                zeroRow = true;
                break;
            }
        }
        
        for (i = 0; i < m; i ++) {
            if (matrix[i][0] == 0) {
                zeroCol = true;
                break;
            }
        }
        
        
        // store zero flag with first row and first column
        for (i = 1; i < m; i ++) {
            for (j = 1; j < n; j ++) {
                if (matrix[i][j] == 0) {
                    matrix[0][j] = matrix[i][0] = 0;
                }
            }
        }
        
        // set matrix zeros
        for (i = 1; i < m; i ++) {
            for (j = 1; j < n; j ++) {
                if (matrix[0][j] == 0 || matrix[i][0] == 0) {
                    matrix[i][j] = 0;
                }
            }
        }
        
        // set row
        if (zeroRow) {
            for (j = 0; j < n; j ++) {
                matrix[0][j] = 0;
            }
        }
        
        // set column
        if (zeroCol) {
            for (i = 0; i < m; i ++) {
                matrix[i][0] = 0;
            }
        }
    }
}
