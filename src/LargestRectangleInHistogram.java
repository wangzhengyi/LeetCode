import java.util.LinkedList;
import java.util.Scanner;

public class LargestRectangleInHistogram {
	public static int largestRectangleAreaTLE(int[] height) {
		if (height == null || height.length == 0)
			return 0;

		int area = 0;

		for (int i = 0; i < height.length; i++) {
			int high = height[i];
			int width = 1;
			for (int j = i - 1; j >= 0 && height[j] >= high; j--) {
				width++;
			}

			for (int j = i + 1; j < height.length && height[j] >= high; j++) {
				width++;
			}

			area = Math.max(area, high * width);
		}

		return area;
	}
	
	public static int largestRectangleArea(int[] height) {
		if (height == null || height.length == 0) return 0;
		
		int area = 0, len = height.length;
		LinkedList<Integer> stack = new LinkedList<Integer>();

		for (int i = 0; i < len; i ++) {
			if (stack.isEmpty() || height[stack.peek()] <= height[i]) {
				stack.push(i);
			} else {
				int index = stack.pop();
				int high = height[index];
				int width = stack.isEmpty() ? i : i - stack.peek() - 1; 
				area = Math.max(area, high * width);
				i -= 1;
			}
		}
		
		while (!stack.isEmpty()) {
			int index = stack.pop();
			int high = height[index];
			int width = stack.isEmpty() ? len : len - stack.peek() - 1; 
			area = Math.max(area, high * width);
		}
		
		return area;
	}
	

	public static void main(String[] args) {
		Scanner cin = new Scanner(System.in);

		while (cin.hasNext()) {
			int n = cin.nextInt();
			int[] height = new int[n];

			for (int i = 0; i < n; i++) {
				height[i] = cin.nextInt();
			}

			int area = largestRectangleArea(height);

			System.out.println(area);
		}

		cin.close();
	}
}