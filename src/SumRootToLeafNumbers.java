public class SumRootToLeafNumbers {
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode(int x) {
            this.val = x;
        }
    }

    public static int sum;

    public static int sumNumbers(TreeNode root) {
        if (root == null) {
            return 0;
        }

        sum = 0;

        dfs(root, root.val);

        return sum;
    }

    public static void dfs(TreeNode p, int num) {
        if (p.left == null && p.right == null) {
            sum += num;
        } else {
            if (p.left != null) {
                dfs(p.left, num * 10 + p.left.val);
            }

            if (p.right != null) {
                dfs(p.right, num * 10 + p.right.val);
            }
        }
    }
}
