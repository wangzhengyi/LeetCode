
public class CountCompleteTreeNodes {
	private class TreeNode {
		@SuppressWarnings("unused")
		public int val;
		TreeNode left;
		TreeNode right;
	}

	public int countNodes(TreeNode root) {
		if (root == null) return 0;
		if (root.left == null && root.right == null) return 1;
		if (root.left != null && root.right == null) return 2;
		
		int left = calculateHeight(root, true);
		int right = calculateHeight(root, false);
		
		if (left == right) {
			return (int)Math.pow(2, left) - 1;
		} else {
			return 1 + countNodes(root.left) + countNodes(root.right);
		}
	}

	private int calculateHeight(TreeNode root, boolean isLeft) {
		int high = 0;
		while (root != null) {
			high++;
			root = isLeft ? root.left : root.right;
		}

		return high;
	}
}
