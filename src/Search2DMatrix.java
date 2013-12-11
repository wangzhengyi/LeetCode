
public class Search2DMatrix {
    public static void main(String[] args) {
        // 杨辉三角的经典题目，不写测试用例了
    }
    
    public static boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null) return false;
        
        int i, j, row = matrix.length, col = matrix[0].length;
        boolean flag = false;
        
        for (i = 0, j = col - 1; i < row && j >= 0;) {
            if (matrix[i][j] == target) {
                flag = true;
                break;
            } else if (matrix[i][j] > target){
                j -= 1;
            } else {
                i += 1;
            }
        }
        
        return flag;
    }
}
