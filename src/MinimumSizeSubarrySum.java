import java.util.Scanner;

public class MinimumSizeSubarrySum {
	public static int minSubArrayLen(int s, int[] nums) {
		if (nums == null || nums.length == 0)
			return 0;

		int bt, ed, minLen, sum;

		// initial variable
		bt = ed = 0;
		minLen = Integer.MAX_VALUE;
		sum = nums[0];

		// slide window algorithm
		while ((ed < nums.length || sum >= s) && bt <= ed) {
			if (sum < s) {
				ed++;
				if (ed < nums.length)
					sum += nums[ed];
			} else {
				int tLen = ed - bt + 1;
				if (tLen < minLen) {
					minLen = tLen;
				}

				sum -= nums[bt++];
			}
		}

		return minLen == Integer.MAX_VALUE ? 0 : minLen;
	}

	public static void main(String[] args) {
		Scanner cin = new Scanner(System.in);

		while (cin.hasNext()) {
			int s = cin.nextInt();
			int n = cin.nextInt();
			int[] nums = new int[n];

			for (int i = 0; i < n; i++) {
				nums[i] = cin.nextInt();
			}

			int len = minSubArrayLen(s, nums);

			System.out.println(len);

		}

		cin.close();
	}
}
