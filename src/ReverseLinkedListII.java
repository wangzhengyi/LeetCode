public class ReverseLinkedListII {
    static class ListNode {
        int val;
        ListNode next;

        public ListNode(int x) {
            this.val = x;
            this.next = null;
        }
    }

    public static ListNode reverseBetween(ListNode head, int m, int n) {
        if (head == null || head.next == null || n == m) {
            return head;
        }

        // 1. add safe node
        ListNode safeNode = new ListNode(Integer.MIN_VALUE);
        safeNode.next = head;

        // 2. find previous node and first switch node
        ListNode pre, swOne;
        pre = safeNode;
        swOne = pre.next;

        for (int i = 1; i < m; i++) {
            pre = swOne;
            swOne = swOne.next;
        }

        // 3. find last switch node and reverse first to last and find post node
        ListNode tmpPre, tmpCur, post;
        tmpPre = swOne;
        tmpCur = swOne.next;
        post = swOne.next;

        for (int i = m; i < n; i++) {
            post = tmpCur.next;
            tmpCur.next = tmpPre;
            tmpPre = tmpCur;
            tmpCur = post;
        }

        // 4. link previous node, switch linked list, post node
        pre.next = tmpPre;
        swOne.next = post;

        return safeNode.next;
    }
}
