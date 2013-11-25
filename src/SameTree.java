public class SameTree {
	public static boolean isSameTree(TreeNode p, TreeNode q) {
		// IMPORTANT: Please reset any member data you declared, as
		// the same Solution instance will be reused for each test case.
		if (p == null && q == null) {
			return true;
		}
		
		if (p != null && q!= null && p.val == q.val) {
			return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
		} else {
			return false;
		}
	}
}
