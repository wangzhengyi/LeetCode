import java.util.LinkedList;

public class ImplementStackUsingQueues {
	private LinkedList<Integer> firstQueue = new LinkedList<Integer>();
	private LinkedList<Integer> secondQueue = new LinkedList<Integer>();

	// Push element x onto stack.
	public void push(int x) {
		firstQueue.addLast(x);
	}

	// Removes the element on top of the stack.
	public void pop() {
		while (firstQueue.size() > 1) {
			secondQueue.addLast(firstQueue.pollFirst());
		}
		firstQueue.pollFirst();

		LinkedList<Integer> tmp = firstQueue;
		firstQueue = secondQueue;
		secondQueue = tmp;

	}

	// Get the top element.
	public int top() {
		while (firstQueue.size() > 1) {
			secondQueue.addLast(firstQueue.pollFirst());
		}
		int element = firstQueue.pollFirst();
		secondQueue.addLast(element);

		LinkedList<Integer> tmp = firstQueue;
		firstQueue = secondQueue;
		secondQueue = tmp;

		return element;
	}

	// Return whether the stack is empty.
	public boolean empty() {
		return firstQueue.isEmpty();
	}
}
