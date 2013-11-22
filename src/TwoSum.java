import java.util.Arrays;
import java.util.Scanner;

public class TwoSum {
	public static void main(String args[]) {
		Scanner cin = new Scanner(System.in);
		int i, n, target, numbers[], loc[];

		while (cin.hasNext()) {
			n = cin.nextInt();
			target = cin.nextInt();
			numbers = new int[n];

			for (i = 0; i < n; i++) {
				numbers[i] = cin.nextInt();
			}

			loc = twosum(numbers, target);

			System.out.println("index1=" + loc[0] + ", index2=" + loc[1]);
		}
	}

	public static int[] twosum(int numbers[], int target) {
		int i, j, tmp[] = new int[numbers.length], loc[] = new int[2];

		System.arraycopy(numbers, 0, tmp, 0, numbers.length);
		Arrays.sort(tmp);

		for (i = 0, j = tmp.length - 1; i < j;) {
			if (tmp[i] + tmp[j] > target) {
				j--;
			} else if (tmp[i] + tmp[j] < target) {
				i++;
			} else {
				int loc1, loc2, k;

				loc1 = loc2 = 0;

				for (k = 0; k < numbers.length; k++) {
					if (numbers[k] == tmp[i]) {
						loc1 = k;
						break;
					}
				}

				for (k = 0; k < numbers.length; k++) {
					if (k != loc1 && numbers[k] == tmp[j]) {
						loc2 = k;
						break;
					}
				}

				loc[0] = loc1 < loc2 ? loc1 + 1 : loc2 + 1;
				loc[1] = loc1 > loc2 ? loc1 + 1 : loc2 + 1;

				break;
			}
		}

		return loc;
	}
}
