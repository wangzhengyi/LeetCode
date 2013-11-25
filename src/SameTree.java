import java.util.*;

public class SameTree {
	public static String[] str1;
	public static String[] str2;
	
	public static int count1;
	public static int count2;
	
	static class TreeNode {
		public int val;
		public TreeNode left;
		public TreeNode right;
		
		public TreeNode(int x) {
			this.val = x;
		}
	}
	
	public static TreeNode createBtreeFirst() {
		TreeNode root = null;

		if (count1 >= str1.length || str1[count1++].equals("#")) {
			return null;
		} else {
			root = new TreeNode(Integer.parseInt(str1[count1 - 1]));
			root.left = createBtreeFirst();
			root.right = createBtreeFirst();
		}

		return root;
	}
	
	public static TreeNode createBtreeSecond() {
		TreeNode root = null;
		
		if (count2 >= str2.length || str2[count2 ++].equals("#")) {
			return null;
		} else {
			root = new TreeNode(Integer.parseInt(str2[count2 - 1]));
			root.left = createBtreeSecond();
			root.right = createBtreeSecond();
		}
		
		return root;
	}
	
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
	
	public static void main(String args[]) {
		Scanner cin = new Scanner(System.in);
		
		while (cin.hasNext()) {
			String s1 = cin.next();
			String s2 = cin.next();
			
			str1 = s1.split(",");
			count1 = 0;
			
			str2 = s2.split(",");
			count2 = 0;
			
			TreeNode p = createBtreeFirst();
			TreeNode q = createBtreeSecond();
			
			if (isSameTree(p, q)) {
				System.out.println("true");
			} else {
				System.out.println("false");
			}
		}
		
		cin.close();
	}
}
