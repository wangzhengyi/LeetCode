import java.util.Scanner;


public class RemoveDuplicatesFromSortedArrayII {
    public static void main(String args[]) {
        int i, n, len, A[];
        Scanner cin = new Scanner(System.in);
        
        while (cin.hasNext()) {
            n = cin.nextInt();
            A = new int[n];
            
            for (i = 0; i < n; i ++) {
                A[i] = cin.nextInt();
            }
            
            len = removeDuplicates(A);
            
            printArray(A, len);
        }
        
        cin.close();
    }
    
    public static void printArray(int[] A, int len) {
        for (int i = 0; i < len; i ++) {
            System.out.printf("%d ", A[i]);
        }
        System.out.println();
    }
    
    public static int removeDuplicates(int[] A) {
        int i, occur, num, len = A.length;
        
        if (len < 3) return len;
        
        for (i = 1, num = 0, occur = 0; i < len; i ++) {
            if (A[i] == A[num]) {
                if (occur == 0) {
                    A[++ num] = A[i];
                }
                occur ++;
            } else {
                A[++ num] = A[i];
                occur = 0;
            }
        }
        
        return num + 1;
    }
}
