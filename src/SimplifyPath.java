import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;

public class SimplifyPath {
    public static String simplifyPath(String path) {
        String[] paths = path.split("/");
        Stack<String> stack = new Stack<String>();

        for (int i = 1; i < paths.length; i++) {
            if (paths[i].equals(".") || paths[i].equals("")) {
                continue;
            } else if (paths[i].equals("..")) {
                if (!stack.isEmpty()) {
                    stack.pop();
                }
            } else {
                stack.push(paths[i]);
            }
        }

        ArrayList<String> array = new ArrayList<String>();
        while (!stack.isEmpty()) {
            array.add(stack.pop());
        }

        StringBuilder sPath = new StringBuilder();
        sPath.append("/");

        for (int i = array.size() - 1; i >= 0; i--) {
            sPath.append(array.get(i));
            if (i != 0) {
                sPath.append("/");
            }
        }

        return sPath.toString();
    }

    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);

        while (cin.hasNext()) {
            String path = cin.nextLine();

            String sPath = simplifyPath(path);

            System.out.println(sPath);
        }

        cin.close();
    }
}
