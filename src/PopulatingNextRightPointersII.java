import java.util.LinkedList;
import java.util.Scanner;

public class PopulatingNextRightPointersII {
    static class TreeLinkNode {
        public int val;
        public TreeLinkNode left, right, next;
        
        public TreeLinkNode(int x) {
            val = x;
            left = right = next = null;
        }
    }
    
    public static String[] arr;
    public static int count;
    
    public static TreeLinkNode createBtree() {
        TreeLinkNode root = null;
        
        if (arr[count ++].equals("#")) {
            root = null;
        } else {
            root = new TreeLinkNode(Integer.parseInt(arr[count - 1]));
            root.left = createBtree();
            root.right = createBtree();
        }
        
        return root;
    }
    
    public static void connect(TreeLinkNode root) {
        if (root == null) {
            return;
        }

        TreeLinkNode p = root.next;

        while (p != null) {
            if (p.left != null) {
                p = p.left;
                break;
            }
            if (p.right != null) {
                p = p.right;
                break;
            }
            p = p.next;
        }

        if (root.right != null) {
            root.right.next = p;
        }

        if (root.left != null) {
            root.left.next = root.right == null ? p : root.right;
        }

        connect(root.right);
        connect(root.left);
    }
    
    public static void levelTraverse(TreeLinkNode root) {
        if (root == null) {
            return;
        }
        
        LinkedList<TreeLinkNode> queue = new LinkedList<TreeLinkNode>();
        queue.addLast(root);
        
        while (! queue.isEmpty()) {
            LinkedList<TreeLinkNode> tmp = new LinkedList<TreeLinkNode>();
            while (! queue.isEmpty()) {
                TreeLinkNode t = queue.removeFirst();
                System.out.printf("%d ", t.val);
                if (t.left != null) {
                    tmp.addLast(t.left);
                }
                if (t.right != null) {
                    tmp.addLast(t.right);
                }
            }
            System.out.println();
            
            queue.addAll(tmp);
        }
    }
    
    
    public static void main(String[] args) {
        String str;
        TreeLinkNode root = null;
        Scanner cin = new Scanner(System.in);
        
        while (cin.hasNext()) {
            str = cin.nextLine();
            arr = str.split(" ");
            count = 0;
            
            root = createBtree();
            
            connect(root);
            
            levelTraverse(root);
        }
        
        cin.close();
    }
}
