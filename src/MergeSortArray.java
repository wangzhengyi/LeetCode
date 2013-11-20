import java.util.*;

public class MergeSortArray {
	public static void main(String args[]) {
		Scanner cin = new Scanner(System.in);

		int m, n, A[], B[];

		while (cin.hasNext()) {
			m = cin.nextInt();
			n = cin.nextInt();

			A = new int[m + n + 1];
			B = new int[n];

			for (int i = 0; i < m; i++) {
				A[i] = cin.nextInt();
			}

			for (int i = 0; i < n; i++) {
				B[i] = cin.nextInt();
			}

			merge(A, m, B, n);

			for (int i = 0; i < m + n; i++) {
				System.out.printf("%d ", A[i]);
			}
			System.out.println();
		}
	}

	public static void merge(int A[], int m, int B[], int n) {
		int i, j, len = n + m - 1;

		for (i = m - 1, j = n - 1; i >= 0 && j >= 0; len--) {
			if (A[i] >= B[j]) {
				A[len] = A[i--];
			} else {
				A[len] = B[j--];
			}
		}

		while (j >= 0) {
			A[len--] = B[j--];
		}
	}
}
