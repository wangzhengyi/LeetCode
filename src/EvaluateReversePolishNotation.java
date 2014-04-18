import java.util.Stack;


public class EvaluateReversePolishNotation {
    public static int evalRPN(String[] tokens) {
        int num1, num2, res = 0;
        Stack<String> stack = new Stack<String>();

        for (int i = 0; i < tokens.length; i++) {
            if (tokens[i].equals("+")) {
                num1 = Integer.parseInt(stack.pop());
                num2 = Integer.parseInt(stack.pop());
                res = num1 + num2;
                stack.push(String.valueOf(res));
            } else if (tokens[i].equals("-")) {
                num1 = Integer.parseInt(stack.pop());
                num2 = Integer.parseInt(stack.pop());
                res = num2 - num1;
                stack.push(String.valueOf(res));
            } else if (tokens[i].equals("*")) {
                num1 = Integer.parseInt(stack.pop());
                num2 = Integer.parseInt(stack.pop());
                res = num1 * num2;
                stack.push(String.valueOf(res));
            } else if (tokens[i].equals("/")) {
                num1 = Integer.parseInt(stack.pop());
                num2 = Integer.parseInt(stack.pop());
                res = num2 / num1;
                stack.push(String.valueOf(res));
            } else {
                stack.push(tokens[i]);
            }
        }

        return Integer.parseInt(stack.pop());
    }
}
