import java.util.ArrayList;
import java.util.LinkedList;


public class BinaryTreePreorderTraversal {
    
    
    static class TreeNode {
        public int val;
        public TreeNode left;
        public TreeNode right;
        public TreeNode(int x) {
            this.val = x;
        }
    }
    
    public static ArrayList<Integer> preorderTraversal(TreeNode root) {
        ArrayList<Integer> list = new ArrayList<Integer>();
        LinkedList<TreeNode> stack = new LinkedList<TreeNode>();
        TreeNode p = root;
        
        while (!stack.isEmpty() || p != null) {
            if (p != null) {
                list.add(p.val);
                stack.addFirst(p);
                p = p.left;
            } else {
                p = stack.removeFirst();
                p = p.right;
            }
        }
        
        return list;
    }
}
