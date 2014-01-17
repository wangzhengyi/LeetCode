public class PartitionList {
    class ListNode {
        int val;
        ListNode next;

        public ListNode(int x) {
            this.val = x;
            this.next = null;
        }
    }

    public ListNode partition(ListNode head, int x) {
        ListNode smaller, bigger, tmps, tmpb;

        smaller = new ListNode(0);
        tmps = smaller;

        bigger = new ListNode(0);
        tmpb = bigger;

        while (head != null) {
            if (head.val < x) {
                tmps.next = head;
                tmps = head;
            } else {
                tmpb.next = head;
                tmpb = head;
            }

            head = head.next;
        }

        tmpb.next = null;
        tmps.next = bigger.next;

        return smaller.next;
    }
}
