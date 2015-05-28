import java.util.Scanner;

public class DivideTwoIntegers {
	public int divide(int dividend, int divisor) {
		boolean flag = false;
		if ((dividend > 0 && divisor > 0) || (dividend < 0 && divisor < 0)) {
			flag = true;
		}
		
		if (dividend == Integer.MIN_VALUE && divisor == -1) {
			return Integer.MAX_VALUE;
		}
		
		long lDividend = dividend > 0 ? (long) dividend : (dividend == Integer.MIN_VALUE) ? 2147483648L : dividend * -1;
		long lDivisor = divisor > 0 ? (long) divisor : (divisor == Integer.MIN_VALUE) ? 2147483648L : divisor * -1;
		
		int res = 0;
		long originalDivisor = lDivisor;
		
		while (lDividend >= originalDivisor) {
			lDivisor = originalDivisor;
			int bit = 1;
			while (lDividend >= lDivisor) {
				res += bit;
				lDividend -= lDivisor;
				lDivisor <<= 1;
				bit *= 2;
			}
		}
				
		return flag ? res : res * -1;
	}

	public static void main(String[] args) {
		Scanner cin = new Scanner(System.in);
		DivideTwoIntegers divideTwoIntegers = new DivideTwoIntegers();
		
		while (cin.hasNext()) {
			int dividend = cin.nextInt();
			int divisor = cin.nextInt();

			int res = divideTwoIntegers.divide(dividend, divisor);

			System.out.println(res);
		}

		cin.close();
	}
}
