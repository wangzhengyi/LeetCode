import java.util.Scanner;


public class MaximumSubarray {
    public static int maxSubArray(int[] A) {
        int i, max, dp[] = new int[A.length];
        
        max = dp[0] = A[0];
        
        for (i = 1; i < A.length; i ++) {
            if (dp[i - 1] > 0) {
                dp[i] = dp[i - 1] + A[i];
            } else {
                dp[i] = A[i];
            }
            
            max = max > dp[i] ? max : dp[i];
        }
        
        return max;
    }
    
    
    public static void main(String[] args) {
        int i, n, A[];
        Scanner cin = new Scanner(System.in);
        
        while (cin.hasNext()) {
            n = cin.nextInt();
            A = new int[n];
            
            for (i = 0; i < n; i ++) {
                A[i] = cin.nextInt();
            }
            
            System.out.println(maxSubArray(A));
        }
    
        cin.close();
    }
    
}
