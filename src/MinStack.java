import java.util.Stack;

public class MinStack {
	private Stack<Integer> normalStack = new Stack<Integer>();
	private Stack<Integer> minStack = new Stack<Integer>();

	public void push(int x) {
		if (minStack.size() == 0 || x <= minStack.peek()) {
			minStack.push(x);
		}
		normalStack.push(x);
	}

	public void pop() {
		if (normalStack.peek().equals(minStack.peek())) {
			minStack.pop();
		}

		normalStack.pop();
	}

	public int top() {
		return normalStack.peek();
	}

	public int getMin() {
		return minStack.peek();
	}
}
