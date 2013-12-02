public class BalancedBinaryTree {
    static class TreeNode {
        public int val;
        public TreeNode left;
        public TreeNode right;

        public TreeNode(int x) {
            this.val = x;
        }
    }

    public static boolean isBalanced(TreeNode root) {
        if (root == null) return true;

        int lh = getHeight(root.left);
        int rh = getHeight(root.right);

        if (Math.abs(lh - rh) > 1) return false;

        return isBalanced(root.left) && isBalanced(root.right);
    }

    public static int getHeight(TreeNode root) {
        if (root == null) return 0;

        return Math.max(getHeight(root.left), getHeight(root.right)) + 1;

    }
}
