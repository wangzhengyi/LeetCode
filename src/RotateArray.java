import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class RotateArray {
	public static void rotate(int[] nums, int k) {
        if (nums.length == 0) {
            return;
        }
        k = k % nums.length;
		List<Integer> array = new ArrayList<>(2 * nums.length);
		for (int i = 0; i < nums.length; i++) {
			array.add(nums[i]);
		}
		for (int i = 0; i < nums.length; i++) {
			array.add(nums[i]);
		}

		int index = nums.length - k;
		for (int i = index, j = 0; i < array.size() && j < nums.length; i++, j++) {
			nums[j] = array.get(i);
		}
	}

	public static void main(String[] args) {
		Scanner cin = new Scanner(System.in);

		while (cin.hasNext()) {
			int n = cin.nextInt();
			int[] nums = new int[n];
			for (int i = 0; i < n; i++) {
				nums[i] = cin.nextInt();
			}

			int k = cin.nextInt();

			rotate(nums, k);

			for (int i = 0; i < nums.length; i++) {
				System.out.printf("%d ", nums[i]);
			}
			System.out.println();
		}
		
		cin.close();
	}
}
