import java.util.ArrayList;
import java.util.Collections;
import java.util.Stack;

public class RecoverBinarySearchTree {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode(int x) {
            this.val = x;
            this.left = this.right = null;
        }
    }

    public static void recoverTree(TreeNode root) {
        ArrayList<TreeNode> nodeArr = new ArrayList<TreeNode>();
        ArrayList<Integer> nodeValue = new ArrayList<Integer>();
        if (root == null || root.left == null && root.right == null) {
            return;
        }

        inorderTraverse(root, nodeArr, nodeValue);

        Collections.sort(nodeValue);

        for (int i = 0; i < nodeArr.size(); i++) {
            nodeArr.get(i).val = nodeValue.get(i);
        }
    }

    public static void inorderTraverse(TreeNode root, ArrayList<TreeNode> nodeArr,
            ArrayList<Integer> nodeValue) {
        Stack<TreeNode> stack = new Stack<TreeNode>();
        TreeNode p = root;

        while (!stack.isEmpty() || p != null) {
            if (p != null) {
                stack.push(p);
                p = p.left;
            } else {
                p = stack.pop();
                nodeArr.add(p);
                nodeValue.add(p.val);
                p = p.right;
            }
        }
    }


    public static void main(String[] args) {
        // TODO Auto-generated method stub

    }

}
