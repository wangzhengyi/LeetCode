public class PopulatingNextRightPointers {
    static class TreeLinkNode {
        int val;
        public TreeLinkNode left, right, next;

        public TreeLinkNode(int x) {
            this.val = x;
        }
    }

    /**
     * 增加next指针
     * 
     * @param root
     */
    public static void connect(TreeLinkNode root) {
        if (root == null) return;

        if (root.left != null) {
            root.left.next = root.right;
        }

        if (root.right != null) {
            root.right.next = root.next == null ? null : root.next.left;
        }

        connect(root.left);
        connect(root.right);
    }
}
