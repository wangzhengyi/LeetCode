public class CountCompleteTreeNodesII {
	private class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		public TreeNode(int x) {
			this.val = x;
		}
	}

	public int countNodes(TreeNode root) {
		int height = calculateTreeHeight(root);
		if (height == 0) return 0;
		if (height == 1) return 1;
		
		int bt = 0, ed = (1 << (height - 1)) - 1;
		while (bt <= ed) {
			int mid = bt + (ed - bt) / 2;
			if (isTreeNodeExists(mid, height, root)) {
				bt = mid + 1;
			} else {
				ed = mid - 1;
			}
		}
		
		return (int)Math.pow(2, height - 1) - 1 + bt;
	}

	private int calculateTreeHeight(TreeNode root) {
		int height = 0;

		while (root != null) {
			height++;
			root = root.left;
		}

		return height;
	}

	private boolean isTreeNodeExists(int mid, int height, TreeNode root) {
		int high = 0;
		int stand = 1 << (height - 2);

		while (high < height - 1 && root != null) {
			root = (mid & stand) == 0 ? root.left : root.right;
			mid <<= 1;
			high++;
		}

		return root != null ? true : false;
	}
	
	public static void main(String[] args) {
		CountCompleteTreeNodesII cctn = new CountCompleteTreeNodesII();
		CountCompleteTreeNodesII.TreeNode root =  cctn.new TreeNode(1);
		CountCompleteTreeNodesII.TreeNode l1node =  cctn.new TreeNode(2);
		CountCompleteTreeNodesII.TreeNode r1node =  cctn.new TreeNode(3);
		CountCompleteTreeNodesII.TreeNode ll2node =  cctn.new TreeNode(4);
		CountCompleteTreeNodesII.TreeNode lr2node =  cctn.new TreeNode(5);
		CountCompleteTreeNodesII.TreeNode rl2node =  cctn.new TreeNode(6);
		CountCompleteTreeNodesII.TreeNode rr2node =  cctn.new TreeNode(7);

		
		root.left = l1node;
		root.right = r1node;
		l1node.left = ll2node;
		l1node.right = lr2node;
		r1node.left = rl2node;
		r1node.right = rr2node;
		
		int count = cctn.countNodes(root);
		
		System.out.println(count);
	}
}
