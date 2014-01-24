import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Scanner;


public class BinaryTreeZigzagLevelOrderTraversal {
    static class TreeNode {
        int val;
        TreeNode left, right;

        public TreeNode(int x) {
            this.val = x;
            this.left = this.right = null;
        }
    }

    public static String[] nodes;
    public static int count;

    public static ArrayList<ArrayList<Integer>> zigzagLevelOrder(TreeNode root) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
        if (root == null) {
            return res;
        }
        LinkedList<TreeNode> queue = new LinkedList<TreeNode>();
        queue.addLast(root);
        int level = 0;

        while (!queue.isEmpty()) {
            LinkedList<TreeNode> tmp = new LinkedList<TreeNode>();
            ArrayList<Integer> list = new ArrayList<Integer>();

            for (int i = 0; i < queue.size(); i++) {
                TreeNode node = queue.get(i);
                list.add(node.val);

                if (node.left != null) {
                    tmp.addLast(node.left);
                }

                if (node.right != null) {
                    tmp.addLast(node.right);
                }
            }

            if (level % 2 == 1) {
                Collections.reverse(list);
            }

            level++;
            queue = tmp;
            res.add(list);
        }

        return res;
    }

    public static TreeNode createBtree() {
        TreeNode root = null;

        if (count < nodes.length && nodes[count++].equals("#")) {
            root = null;
        } else if (count >= nodes.length) {
            // do nothing
        } else {
            root = new TreeNode(Integer.parseInt(nodes[count - 1]));
            root.left = createBtree();
            root.right = createBtree();
        }

        return root;
    }

    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);

        while (cin.hasNext()) {
            String str = cin.nextLine();
            nodes = str.split(" ");
            count = 0;

            TreeNode root = createBtree();
            ArrayList<ArrayList<Integer>> res = zigzagLevelOrder(root);

            System.out.println(res);
        }

        cin.close();
    }
}
