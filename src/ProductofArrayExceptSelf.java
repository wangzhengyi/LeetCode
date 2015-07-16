public class ProductofArrayExceptSelf {
	public int[] productExceptSelf(int[] nums) {
		int len = nums.length, p;
		int[] arr = new int[nums.length];

		arr[0] = p = 1;
		for (int i = 1; i < len; i++) {
			p = p * nums[i - 1];
			arr[i] = p;
		}

		p = 1;
		for (int i = len - 2; i >= 0; i--) {
			p = p * nums[i + 1];
			arr[i] *= p;
		}

		return arr;
	}

	public int[] productExceptSelfRev(int[] nums) {
		multiply(nums, 1, 0, nums.length);

		return nums;
	}

	private int multiply(int[] a, int fwdProduct, int indx, int N) {
		int revProduct = 1;
		if (indx < N) {
			revProduct = multiply(a, fwdProduct * a[indx], indx + 1, N);
			int cur = a[indx];
			a[indx] = fwdProduct * revProduct;
			revProduct *= cur;
		}
		return revProduct;
	}

	public static void main(String[] args) {
		int[] nums = new int[] { 2, 3, 4};
		ProductofArrayExceptSelf paes = new ProductofArrayExceptSelf();
		int[] res = paes.productExceptSelfRev(nums);
		for (int n : res) {
			System.out.printf("%d ", n);
		}
		System.out.println();
	}
}