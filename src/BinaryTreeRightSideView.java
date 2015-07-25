import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;


public class BinaryTreeRightSideView {
	private static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
	}
	
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> res = new ArrayList<Integer>();
        
        if (root == null) {
        	return res;
        }
                
        LinkedList<TreeNode> queue = new LinkedList<TreeNode>();
        queue.addLast(root);
        
        while (! queue.isEmpty()) {
        	TreeNode rightNode = null;
        	
        	int size = queue.size();
        	
        	for (int i = 0; i < size; i ++) {
        		rightNode = queue.poll();
        		if (rightNode.left != null) {
        			queue.add(rightNode.left);
        		}
        		
        		if (rightNode.right != null) {
        			queue.add(rightNode.right);
        		}
        	}
        	
        	if (rightNode != null) {
        		res.add(rightNode.val);
        	}
        }
                
        return res;
    }
}
