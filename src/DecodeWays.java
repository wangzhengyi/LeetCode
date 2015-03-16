import java.util.Scanner;

public class DecodeWays {
	public static int numDecodings(String s) {
		if (s == null || s.length() == 0 || s.charAt(0) == '0') {
			return 0;
		}

		int[] nums = new int[s.length()];
		nums[0] = 1;

		for (int i = 1; i < s.length(); i++) {
			if (s.charAt(i) == '0') {
				if (s.charAt(i - 1) == '2' || s.charAt(i - 1) == '1') {
					nums[i] = i >= 2 ? nums[i - 2] : 1;
				} else {
					return 0;
				}
			} else {
				if (s.charAt(i - 1) == '1') {
					nums[i] = i >= 2 ? nums[i - 1] + nums[i - 2] : nums[i - 1] + 1;
				} else if (s.charAt(i - 1) == '2') {
					nums[i] = s.charAt(i) <= '6' ? (i >= 2 ? nums[i - 1] + nums[i - 2] : nums[i - 1] + 1) : nums[i - 1];
				} else {
					nums[i] = nums[i - 1];
				}
			}
		}

		return nums[s.length() - 1];
	}

	public static void main(String[] args) {
		Scanner cin = new Scanner(System.in);

		while (cin.hasNext()) {
			String str = cin.nextLine();

			int n = numDecodings(str);

			System.out.println(n);
		}

		cin.close();
	}
}
