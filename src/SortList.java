public class SortList {
    static class ListNode {
        int val;
        ListNode next;

        public ListNode(int x) {
            this.val = x;
            this.next = null;
        }
    }

    public static ListNode sortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        
        int count, middle;

        ListNode p, left, right;

        // the length of the list
        p = head;
        count = 0;
        while (p != null) {
            count++;
            p = p.next;
        }

        // distinguish the left and right
        middle = count / 2;
        p = head;
        left = right = head;
        for (int i = 0; i < middle - 1; i++) {
            p = p.next;
        }
        right = p.next;
        p.next = null;

        // recursive
        left = sortList(left);
        right = sortList(right);

        // merge two list
        ListNode res = mergeTwoList(left, right);

        return res;
    }

    public static ListNode mergeTwoList(ListNode left, ListNode right) {
        ListNode safeNode = new ListNode(Integer.MAX_VALUE);
        ListNode p = safeNode;

        while (left != null && right != null) {
            if (left.val <= right.val) {
                p.next = left;
                left = left.next;
            } else {
                p.next = right;
                right = right.next;
            }
            
            p = p.next;
        }

        if (left != null) {
            p.next = left;
        }

        if (right != null) {
            p.next = right;
        }

        return safeNode.next;
    }
}
