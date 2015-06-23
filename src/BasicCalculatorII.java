import java.util.LinkedList;

public class BasicCalculatorII {
	public int calculate(String s) {
		LinkedList<Integer> dataStack = new LinkedList<Integer>();
		LinkedList<Character> optStack = new LinkedList<Character>();

		for (int i = 0, len = s.length(); i < len; i++) {
			if (s.charAt(i) == ' ') {
				continue;
			}

			if (s.charAt(i) <= '9' && s.charAt(i) >= '0') {
				int res = s.charAt(i) - '0';
				
				while (++i < len && (s.charAt(i) <= '9' && s.charAt(i) >= '0')) {
					res = res * 10 + (s.charAt(i) - '0');
				}
				
				dataStack.push(res);
				i -= 1;
				continue;
			}

			while (!optStack.isEmpty() && isTopOptHigherPriority(optStack.peek(), s.charAt(i))) {
				char topOpt = optStack.pollFirst();
				int b = dataStack.pollFirst();
				int a = dataStack.pollFirst();
				int res = calculate(topOpt, a, b);
				dataStack.push(res);
			} 
			optStack.push(s.charAt(i));
		}
		
		while (!optStack.isEmpty()) {
			char topOpt = optStack.pollFirst();
			int b = dataStack.pollFirst();
			int a = dataStack.pollFirst();
			int res = calculate(topOpt, a, b);
			dataStack.push(res);
		}
		
		return dataStack.peek();
	}

	private boolean isTopOptHigherPriority(char opt1, char opt2) {		
		if ((opt1 == '+' || opt1 == '-') && (opt2 == '*' || opt2 == '/')) {
			return false;
		}
		
		return true;
	}
	
	private int calculate(char operator, int a, int b) {
		switch (operator) {
		case '+':
			return a + b;
		case '-':
			return a - b;
		case '*':
			return a * b;
		case '/':
			return a / b;
		}

		return Integer.MAX_VALUE;
	}
	
	public static void main(String[] args) {
		String s = "1*2-3/4+5*6-7*8+9/10";
		
		BasicCalculatorII bc = new BasicCalculatorII();
		int res = bc.calculate(s);
		
		System.out.println(res);
	}
}
