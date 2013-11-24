import java.util.*;

public class ReverseInteger {
	public static void main(String args[]) {
		Scanner cin = new Scanner(System.in);
		int x;

		while (cin.hasNext()) {
			x = cin.nextInt();

			x = reverse(x);

			System.out.println(x);
		}
	}

	public static int reverse(int x) {
		boolean flag;
		int a;
		long original, max = 2147483647L, min = 2147483648L;

		if (x < 0) {
			flag = true;
			original = x * -1;
		} else {
			flag = false;
			original = x;
		}

		for (original = 0; x != 0; x /= 10) {
			a = x % 10;
			if (flag) {
				if (10 * original + a > min) {
					return (int) (min * -1);
				}
			} else {
				if (10 * original + a > max) {
					return (int) max;
				}
			}

			original = 10 * original + a;
		}

		return (int) original;
	}
}