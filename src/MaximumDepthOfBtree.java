import java.util.Scanner;

public class MaximumDepthOfBtree {
	public static String str[];
	public static int count;
	
	static class TreeNode {
		public int val;
		public TreeNode left;
		public TreeNode right;
		
		public TreeNode(int x) {
			this.val = x;
		}
	}
	
	public static TreeNode createBtree() {
		TreeNode root = null;
		
		if (str[count ++].equals("#")) {
			return null;
		} else {
			root = new TreeNode(Integer.parseInt(str[count - 1]));
			root.left = createBtree();
			root.right = createBtree();
		}
		
		return root;
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
	
	public static void main(String args[]) {
		Scanner cin = new Scanner(System.in);
		
		while (cin.hasNext()) {
			String s = cin.nextLine();
			
			str = s.split(",");
			count = 0;
			
			TreeNode root = createBtree();
			
			int level = maxDepth(root);
			
			System.out.println(level);
		}
		
		cin.close();
	}
}