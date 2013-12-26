import java.util.Scanner;

public class MinimumDepthOfBinaryTree {
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode(int x) {
            val = x;
        }
    }

    public static String[] nodes;
    public static int count;
    public static int min;

    public static int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }

        min = Integer.MAX_VALUE;
        dfsBtree(root, 1);

        return min;
    }

    public static void dfsBtree(TreeNode p, int depth) {
        if (p.left == null && p.right == null) {
            if (depth < min) {
                min = depth;
            }
        } else {
            if (p.left != null) {
                dfsBtree(p.left, depth + 1);
            }

            if (p.right != null) {
                dfsBtree(p.right, depth + 1);
            }
        }
    }

    public static TreeNode createBtree() {
        TreeNode root = null;
        if (nodes[count++].equals("#")) {
            root = null;
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

            int depth = minDepth(root);

            System.out.println(depth);
        }

        cin.close();
    }
}
