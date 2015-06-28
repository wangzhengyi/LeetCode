import java.util.LinkedList;


public class BasicCalculator {
	public int calculate(String s) {
		LinkedList<Integer> stack = new LinkedList<Integer>();
		int result = 0;
		int sign = 1;
		int data = 0;
		
		for (int i = 0; i < s.length(); i ++) {
			if (s.charAt(i) >= '0' && s.charAt(i) <= '9') {
				data = 10 * data + s.charAt(i) - '0';
			} else if (s.charAt(i) == '+') {
				result += data * sign;
				data = 0;
				sign = 1;
			} else if (s.charAt(i) == '-') {
				result += data * sign;
				data = 0;
				sign = -1;
			} else if (s.charAt(i) == '(') {
				stack.push(result);
				stack.push(sign);
				result = 0;
				sign = 1;
				data = 0;
			} else if (s.charAt(i) == ')') {
				result += data * sign;
				result *= stack.pop();
				result += stack.pop();
				data = 0;
				sign = 1;
			}
		}
		
		return result + data * sign;
	}


	public static void main(String[] args) {
		String s = "1 + (2- 3)";

		BasicCalculator bc = new BasicCalculator();
		int res = bc.calculate(s);

		System.out.println(res);
	}
}
