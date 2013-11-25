public class MaximumDepthOfBtree {
	public static void main(String args[]) {
	}

	public static int maxDepth(TreeNode root) {
		if (root == null) {
			return 0;
		} else if (root.left == null && root.right == null) {
			return 1;
		} else {
			int ldepth, rdepth;

			ldepth = maxDepth(root.left);
			rdepth = maxDepth(root.right);

			return ldepth > rdepth ? ldepth + 1 : rdepth + 1;
		}
	}
}