
public class MaximumProductSubarray {
	public int maxProduct(int[] A) {
		if (A == null || A.length == 0) {
			return 0;
		}
		
		int min, max, product;
		
		min = max = product = A[0];
		
		for (int i = 1; i < A.length; i ++) {
			int tempMax = A[i] * max;
			int tempMin = A[i] * min;
			
			max = Math.max(A[i], Math.max(tempMax, tempMin));
			min = Math.min(A[i], Math.min(tempMax, tempMin));
			
			product = Math.max(product, max);
		}
		
		return product;
	}
	
}
