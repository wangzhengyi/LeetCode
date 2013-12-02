import java.util.ArrayList;
import java.util.LinkedList;


public class BinaryTreeLevelOrderTraversal {
    static class TreeNode {
        public int val;
        public TreeNode left;
        public TreeNode right;

        public TreeNode(int x) {
            this.val = x;
        }
    }

    public ArrayList<ArrayList<Integer>> levelOrder(TreeNode root) {
        ArrayList<ArrayList<Integer>> list = new ArrayList<ArrayList<Integer>>();
        LinkedList<TreeNode> queue = new LinkedList<TreeNode>();
        TreeNode p;
        int data;

        if (root == null) {
            return list;
        } else {
            queue.addLast(root);
        }

        while (!queue.isEmpty()) {
            ArrayList<Integer> sublist = new ArrayList<Integer>();
            LinkedList<TreeNode> subQueue = new LinkedList<TreeNode>();

            while (!queue.isEmpty()) {
                p = queue.removeFirst();
                sublist.add(p.val);

                if (p.left != null) {
                    subQueue.addLast(p.left);
                }

                if (p.right != null) {
                    subQueue.addLast(p.right);
                }
            }

            list.add(sublist);
            queue.addAll(subQueue);
        }

        return list;
    }
}
