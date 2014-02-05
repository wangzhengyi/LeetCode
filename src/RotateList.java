public class RotateList {
    static class ListNode {
        int val;
        ListNode next;

        public ListNode(int x) {
            this.val = x;
            this.next = null;
        }
    }

    public static ListNode rotateRight(ListNode head, int n) {
        if (head == null || head.next == null) {
            return head;
        }
        
        ListNode p = head;
        int count = 0;

        while (p != null) {
            count++;
            p = p.next;
        }

        n = n % count;

        if (n == 0) {
            return head;
        }

        ListNode pre, cur, fast, slow;
        pre = null;
        cur = head;
        fast = slow = head;
        int distance = 0;

        while (distance != n) {
            fast = fast.next;
            distance++;
        }

        while (fast != null) {
            pre = slow;
            slow = slow.next;
            cur = fast;
            fast = fast.next;
        }

        // rotate list
        pre.next = null;
        cur.next = head;

        return slow;
    }
}
