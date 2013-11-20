public class SingleNumber {
	public static void main(String[] args) {
		int[] A = new int[] { 1, 1, 2, 2, 3, 4, 3 };

		SingleNumber sn = new SingleNumber();

		int key = sn.singleNumber(A);

		System.out.println(key);
	}

	public int singleNumber(int[] A) {
		// IMPORTANT: Please reset any member data you declared, as
		// the same Solution instance will be reused for each test case.

		int key = 0;

		for (int i = 0; i < A.length; i++) {
			key ^= A[i];
		}

		return key;
	}
}
