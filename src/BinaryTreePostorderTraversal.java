import java.util.ArrayList;
import java.util.LinkedList;

public class BinaryTreePostorderTraversal {
    static class TreeNode {
        public int val;
        public TreeNode left;
        public TreeNode right;

        public TreeNode(int x) {
            this.val = x;
        }
    }

    public static ArrayList<Integer> postorderTraversal(TreeNode root) {
        ArrayList<Integer> list = new ArrayList<Integer>();
        LinkedList<TreeNode> stack = new LinkedList<TreeNode>();
        TreeNode pre = null;
        
        while (!stack.isEmpty() || root != null) {
            if (root != null) {
                stack.addFirst(root);
                root = root.left;
            } else {
                root = stack.removeFirst();
                if (root.right == null || root.right == pre) {
                    pre = root;
                    list.add(root.val);
                    root = null;
                } else {
                    stack.addFirst(root);
                    root = root.right;
                }
            }
        }
        
        return list;
    }
}
