import java.util.ArrayList;

public class ConvertSortedListToBinarySearchTree {
    static class ListNode {
        int val;
        ListNode next;

        public ListNode(int x) {
            this.val = x;
            this.next = null;
        }
    }

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode(int x) {
            this.val = x;
        }
    }

    public static TreeNode createBST(int bt, int ed, ArrayList<Integer> list) {
        TreeNode root = null;
        if (bt <= ed) {
            int mid = bt + (ed - bt) / 2;
            root = new TreeNode(list.get(mid));
            root.left = createBST(bt, mid - 1, list);
            root.right = createBST(mid + 1, ed, list);
        }

        return root;
    }

    public static TreeNode sortedListToBST(ListNode head) {
        TreeNode root = null;

        if (head == null) {
            return root;
        }

        ListNode p = head;
        ArrayList<Integer> list = new ArrayList<Integer>();

        while (p != null) {
            list.add(p.val);
            p = p.next;
        }

        root = createBST(0, list.size() - 1, list);

        return root;
    }
}
