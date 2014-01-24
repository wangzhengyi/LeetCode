import java.util.Scanner;
import java.util.Stack;

public class FlattenBinaryTreeToLinkedList {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode(int x) {
            this.val = x;
            this.left = this.right = null;
        }
    }

    public static void flatten(TreeNode root) {
        if (root == null) {
            return;
        }

        TreeNode leftNode, rightNode;

        leftNode = root.left;
        rightNode = root.right;

        root.left = null;
        if (leftNode != null) {
            root.right = leftNode;
            while (leftNode.right != null) {
                leftNode = leftNode.right;
            }
            leftNode.right = rightNode;
        }

        flatten(root.right);
    }

    public static String[] nodes;
    public static int count;

    public static TreeNode createBtree() {
        TreeNode root = null;

        if (count >= nodes.length || nodes[count++].equals("#")) {
            return root;
        } else {
            root = new TreeNode(Integer.parseInt(nodes[count - 1]));
            root.left = createBtree();
            root.right = createBtree();
            return root;
        }
    }

    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);

        while (cin.hasNext()) {
            String str = cin.nextLine();
            nodes = str.split(" ");
            count = 0;

            TreeNode root = createBtree();

            flatten(root);

            while (root != null) {
                System.out.printf("%d ", root.val);
                root = root.right;
            }
            System.out.println();
        }

        cin.close();
    }

}
