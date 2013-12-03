import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;


public class BinaryTreeLevelOrderTraversalII {
    static class TreeNode {
        public int val;
        public TreeNode left;
        public TreeNode right;
        
        public TreeNode (int x) {
            this.val = x;
        }
    }
    
    public ArrayList<ArrayList<Integer>> levelOrderBottom(TreeNode root) {
        ArrayList<ArrayList<Integer>> list = new ArrayList<ArrayList<Integer>>();
        LinkedList<TreeNode> queue = new LinkedList<TreeNode>();
        TreeNode p;
        
        if (root == null) {
            return list;
        }
        
        queue.addLast(root);
        
        while (! queue.isEmpty()) {
            ArrayList<Integer> sublist = new ArrayList<Integer>();
            LinkedList<TreeNode> subqueue = new LinkedList<TreeNode>();
            
            while (! queue.isEmpty()) {
                p = queue.removeFirst();
                sublist.add(p.val);
                
                if (p.left != null) {
                    subqueue.addLast(p.left);
                }
                
                if (p.right != null) {
                    subqueue.addLast(p.right);
                }
            }
            
            list.add(sublist);
            queue.addAll(subqueue);
        }
        
        Collections.reverse(list);
        return list;
    }
}
