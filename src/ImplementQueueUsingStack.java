import java.util.LinkedList;


public class ImplementQueueUsingStack {
	private LinkedList<Integer> stack1 = new LinkedList<Integer>();
	private LinkedList<Integer> stack2 = new LinkedList<Integer>();
	
    // Push element x to the back of queue.
    public void push(int x) {
        stack1.push(x);
    }

    // Removes the element from in front of queue.
    public void pop() {
        while (stack1.size() > 1) {
        	stack2.push(stack1.pop());
        }
        stack1.pollLast();
        while (!stack2.isEmpty()) {
        	stack1.push(stack2.pop());
        }
    }

    // Get the front element.
    public int peek() {
        while (stack1.size() > 1) {
        	stack2.push(stack1.pop());
        }
        int x = stack1.pop();
        stack1.push(x);
        while (!stack2.isEmpty()) {
        	stack1.push(stack2.pop());
        }
        
        return x;
    }

    // Return whether the queue is empty.
    public boolean empty() {
        return stack1.isEmpty();
    }
    
    public static void main(String[] args) {
    	ImplementQueueUsingStack iqus = new ImplementQueueUsingStack();
    	iqus.push(1);
    	iqus.push(2);
    	System.out.println(iqus.peek());
    }
}
