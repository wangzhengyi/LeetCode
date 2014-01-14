import java.util.*;


public class PathSumII {
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode(int x) {
            this.val = x;
        }
    }

    private static String[] nodes;
    private static int count;

    /**
     * create binary tree
     * 
     * @return root node
     */
    public static TreeNode createBtree() {
        TreeNode root = null;

        if (count < nodes.length && nodes[count++].equals("#")) {
            root = null;
        } else if (count >= nodes.length) {
            root = null;
        } else {
            root = new TreeNode(Integer.parseInt(nodes[count - 1]));
            root.left = createBtree();
            root.right = createBtree();
        }

        return root;
    }

    /**
     * previous traverse binary tree
     * 
     * @param root
     */
    public static void preTraverse(TreeNode root) {
        LinkedList<TreeNode> stack = new LinkedList<PathSumII.TreeNode>();
        TreeNode p = root;

        while (!stack.isEmpty() || p != null) {
            if (p != null) {
                System.out.printf("%d ", p.val);
                stack.addLast(p);
                p = p.left;
            } else {
                p = stack.removeLast();
                p = p.right;
            }
        }
    }

    /**
     * depth first search the binary tree
     * 
     * @param root
     * @param target
     * @param tmp
     * @param list
     */
    public static void dfsBtree(TreeNode root, int target, ArrayList<Integer> tmp,
            ArrayList<ArrayList<Integer>> list) {
        if (root.left == null && root.right == null) {
            int sum = 0;
            for (int i = 0; i < tmp.size(); i++) {
                sum += tmp.get(i);
            }
            if (sum == target) {
                list.add(new ArrayList<Integer>(tmp));
            }
        } else {
            if (root.left != null) {
                tmp.add(root.left.val);
                dfsBtree(root.left, target, tmp, list);
                tmp.remove(tmp.size() - 1);
            }

            if (root.right != null) {
                tmp.add(root.right.val);
                dfsBtree(root.right, target, tmp, list);
                tmp.remove(tmp.size() - 1);
            }
        }
    }

    public static ArrayList<ArrayList<Integer>> pathSum(TreeNode root, int sum) {
        ArrayList<ArrayList<Integer>> list = new ArrayList<ArrayList<Integer>>();
        if (root == null) {
            return list;
        }

        ArrayList<Integer> tmp = new ArrayList<Integer>();
        tmp.add(root.val);
        dfsBtree(root, sum, tmp, list);

        return list;
    }

    public static void main(String args[]) {
        Scanner cin = new Scanner(System.in);

        while (cin.hasNext()) {
            int sum = Integer.parseInt(cin.nextLine());
            String str = cin.nextLine();
            nodes = str.split("\\s");
            count = 0;

            TreeNode root = createBtree();

            // test build tree
            // preTraverse(root);

            ArrayList<ArrayList<Integer>> list = pathSum(root, sum);
            for (int i = 0; i < list.size(); i++) {
                for (int j = 0; j < list.get(i).size(); j++) {
                    System.out.printf("%d ", list.get(i).get(j));
                }
                System.out.println();
            }
        }

        cin.close();
    }
}
