import java.util.*;

public class SingleNumber {
	public static void main(String[] args) {
		int n, key, A[];
		
		Scanner cin = new Scanner(System.in);
		
		while (cin.hasNext()) {
			// 接收数组A
			n = cin.nextInt();
			A = new int[n];
			for (int i = 0; i < n; i ++) {
				A[i] = cin.nextInt();
			}
			
			// 调用方法
			SingleNumber sn = new SingleNumber();

			key = sn.singleNumber(A, n);

			System.out.println(key);
			
		}
	}

	public int singleNumber(int[] A,  int n) {
		// IMPORTANT: Please reset any member data you declared, as
		// the same Solution instance will be reused for each test case.

		for (int i = 1; i < A.length; i++) {
			A[0] ^= A[i];
		}

		return A[0];
	}
}
