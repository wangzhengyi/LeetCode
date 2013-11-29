import java.util.ArrayList;
import java.util.LinkedList;


public class BinaryTreeInorderTraversal {
    static class TreeNode {
        public int val;
        public TreeNode left;
        public TreeNode right;

        public TreeNode(int x) {
            this.val = x;
        }
    }

    /**
     * 二叉树中序遍历
     * 
     * @param root
     * @return
     */
    public ArrayList<Integer> inorderTraversal(TreeNode root) {
        LinkedList<TreeNode> stack = new LinkedList<TreeNode>();
        ArrayList<Integer> list = new ArrayList<Integer>();
        TreeNode p = root;

        while (!stack.isEmpty() || p != null) {
            if (p != null) {
                stack.addFirst(p);
                p = p.left;
            } else {
                p = stack.removeFirst();
                list.add(p.val);
                p = p.right;
            }
        }

        return list;
    }
}
