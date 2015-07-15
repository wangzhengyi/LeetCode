import java.util.ArrayList;
import java.util.List;

public class LowestCommonAncestorOfABinarySearchTree {
	private class TreeNode {
		public int val;
		public TreeNode left;
		public TreeNode right;

		public TreeNode(int x) {
			this.val = x;
		}
	}

	public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
		List<TreeNode> pList = new ArrayList<TreeNode>();
		List<TreeNode> qList = new ArrayList<TreeNode>();
		
		getPath(root, p, pList);
		getPath(root, q, qList);
		
		int len = pList.size() >= qList.size() ? qList.size() - 1 : pList.size() - 1;
		for (int i = len; i >= 0; i --) {
			if (pList.get(i) == qList.get(i)) {
				return pList.get(i);
			}
		}
		return null;
	}
	
	private void getPath(TreeNode root, TreeNode node, List<TreeNode> list) {
		TreeNode p = root;
		list.add(p);
		
		while (p != null && p != node) {
			if (p.val < node.val) {
				p = p.left;
				list.add(p);
			} else {
				p = p.right;
				list.add(p);
			}
		}
		list.add(p);
	}
}
