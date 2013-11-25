import java.util.Scanner;

public class BinaryTree {
	public static String[] str;
	public static int count;

	/**
	 * 静态内部类，定义二叉树节点
	 */
	static class TreeNode {
		public String data;
		TreeNode lchild;
		TreeNode rchild;

		public TreeNode(String x) {
			this.data = x;
		}
	}

	/**
	 * 根据前序序列递归构建二叉树
	 * 
	 * @return
	 */
	public static TreeNode createBtree() {
		TreeNode root = null;

		if (count >= str.length || str[count++].equals("#")) {
			root = null;
		} else {
			root = new TreeNode(str[count - 1]);
			root.lchild = createBtree();
			root.rchild = createBtree();
		}

		return root;
	}

	/**
	 * 前序遍历
	 * 
	 * @param root
	 */
	public static void preTraverse(TreeNode root) {
		if (root != null) {
			System.out.print(root.data + " ");
			preTraverse(root.lchild);
			preTraverse(root.rchild);
		}
	}

	/**
	 * 中序遍历
	 * 
	 * @param root
	 */
	public static void inTraverse(TreeNode root) {
		if (root != null) {
			inTraverse(root.lchild);
			System.out.print(root.data + " ");
			inTraverse(root.rchild);
		}
	}

	/**
	 * 后序遍历
	 * 
	 * @param root
	 */
	public static void postTraverse(TreeNode root) {
		if (root != null) {
			postTraverse(root.lchild);
			postTraverse(root.rchild);
			System.out.print(root.data + " ");
		}
	}

	public static void main(String args[]) {
		Scanner cin = new Scanner(System.in);

		while (cin.hasNext()) {
			String s = cin.nextLine();
			str = s.split(",");

			count = 0;

			TreeNode root = createBtree();

			// 前序遍历
			preTraverse(root);
			System.out.println();

			// 中序遍历
			inTraverse(root);
			System.out.println();

			// 后序遍历
			postTraverse(root);
			System.out.println();
		}
	}
}
