import java.util.ArrayList;
import java.util.List;


public class LowestCommonAncestorOfaBinaryTree {
	private class TreeNode {
		public int val;
		TreeNode left;
		TreeNode right;
		public TreeNode(int x) {
			this.val = x;
		}
	}
	
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        List<TreeNode> pList = new ArrayList<>();
        List<TreeNode> qList = new ArrayList<>();
        
        dfsBinaryTree(root, p, pList);
        dfsBinaryTree(root, q, qList);
        
        TreeNode ancestor = null;
        for (int i = 0; i < pList.size() && i < qList.size(); i ++) {
        	if (pList.get(i) == qList.get(i)) {
        		ancestor = pList.get(i);
        	} else {
        		break;
        	}
        }
        
        return ancestor;
    }
    
    private void dfsBinaryTree(TreeNode root, TreeNode t, List<TreeNode> stack) {
    	// 后序遍历算法
    	TreeNode pre = null;
    	while (!stack.isEmpty() || root != null) {
    		if (root != null) {
    			stack.add(root);
    			root = root.left;
    		} else {
    			root = stack.remove(stack.size() - 1);
    			if (root == t) {
    				stack.add(root);
    				return;
    			}
    			if (root.right != null && root.right != pre) {
    				stack.add(root);
    				root = root.right;
    			} else {
    				pre = root;
    				root = null;
    			}
    		}
    	}
    }
    
    public static void main(String[] args) {
    	LowestCommonAncestorOfaBinaryTree lcab = new LowestCommonAncestorOfaBinaryTree();
    	TreeNode root = lcab.new TreeNode(-1);
    	TreeNode fll = lcab.new TreeNode(0);
    	TreeNode flr = lcab.new TreeNode(3);
    	TreeNode sll = lcab.new TreeNode(-2);
    	TreeNode slr = lcab.new TreeNode(4);
    	TreeNode tll = lcab.new TreeNode(8);

    	root.left = fll;
    	root.right = flr;
    	fll.left = sll;
    	fll.right = slr;
    	sll.left = tll;
    	
    	
    	TreeNode ancestor = lcab.lowestCommonAncestor(root, tll, fll);
    	System.out.println(ancestor.val);
    }
    
}
