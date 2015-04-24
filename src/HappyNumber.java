import java.util.HashSet;
import java.util.Scanner;

public class HappyNumber {
	public static boolean isHappy(int n) {
		HashSet<Integer> hashSet = new HashSet<Integer>();
		boolean res = false;

		while (!hashSet.contains(n)) {
			hashSet.add(n);
			n = calDigitsSquares(n);
			if (n == 1) {
				res = true;
				break;
			}
		}

		return res;
	}

	private static int calDigitsSquares(int n) {
		int res = 0;

		while (n > 0) {
			int digit = n % 10;
			res += digit * digit;
			n /= 10;
		}

		return res;
	}

	public static void main(String[] args) {
		Scanner cin = new Scanner(System.in);

		while (cin.hasNext()) {
			int n = cin.nextInt();

			boolean res = isHappy(n);

			System.out.println("res is :" + res);
		}

		cin.close();
	}
}
