public class InvertBinaryTree {
	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			this.val = x;
		}
	}

	public TreeNode invertTree(TreeNode root) {
		if (root == null)
			return root;

		TreeNode tmp = root.left;
		root.left = root.right;
		root.right = tmp;
		
		if (root.left != null) {
			invertTree(root.left);
		}
		if (root.right != null) {
			invertTree(root.right);
		}
		
		return root;
	}

}
