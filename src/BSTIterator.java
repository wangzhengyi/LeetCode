import java.util.Stack;


public class BSTIterator {
	private Stack<TreeNode> mStack;
	
	public BSTIterator(TreeNode root) {
		mStack = new Stack<TreeNode>();
		while (root != null) {
			mStack.push(root);
			root = root.left;
		}
	}
	
	public boolean hasNext() {
		return ! mStack.empty();
	}
	
	public int next() {
		TreeNode p = mStack.pop();
		int res = p.val;
		if (p.right != null) {
			TreeNode node = p.right;
			while (node != null) {
				mStack.push(node);
				node = node.left;
			}
		}
		
		return res;
	}
	
	public static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) {
			val = x;
		}
	}
}
