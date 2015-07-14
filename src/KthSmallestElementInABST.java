import java.util.LinkedList;

public class KthSmallestElementInABST {
	private class TreeNode {
		int val;
		public TreeNode left;
		public TreeNode right;

		public TreeNode(int x) {
			val = x;
		}
	}

	public int kthSmallest(TreeNode root, int k) {
		LinkedList<TreeNode> stack = new LinkedList<TreeNode>();
		TreeNode p = root;
		int cnt = 0, kth = Integer.MIN_VALUE;
		
		while (!stack.isEmpty() || p != null) {
			if (p != null) {
				stack.push(p);
				p = p.left;
			} else {
				p = stack.pop();
				if (p != null) {
					cnt ++;
				}
				if (cnt == k) {
					kth = p.val;
					break;
				}
				p = p.right;
			}
		}
		
		return kth;
	}
}
