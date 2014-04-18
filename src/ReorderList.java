import java.util.Scanner;


public class ReorderList {
    static class ListNode {
        int val;
        ListNode next;

        public ListNode(int x) {
            this.val = x;
            this.next = null;
        }
    }

    public static void reorderList(ListNode head) {
        // special case
        if (head == null || head.next == null || head.next.next == null) {
            return;
        }

        int length = 0;
        ListNode p = head;

        // calculate length of the list
        while (p != null) {
            length++;
            p = p.next;
        }

        // divide the list
        ListNode fNode = head, sNode;
        int i = 0;
        for (i = 0, p = null, sNode = head; i <= (length - 1) / 2; i++) {
            p = sNode;
            sNode = sNode.next;
        }
        p.next = null;

        // revert the second list
        ListNode pre, cur, post;
        pre = null;
        cur = sNode;
        while (cur != null) {
            post = cur.next;
            cur.next = pre;
            pre = cur;
            cur = post;
        }
        sNode = pre;

        // merge two list
        ListNode res = head = fNode;
        fNode = fNode.next;
        while (fNode != null && sNode != null) {
            res.next = sNode;
            sNode = sNode.next;
            res = res.next;
            res.next = fNode;
            res = res.next;
            fNode = fNode.next;
        }

        if (fNode != null) {
            res.next = fNode;
        }

        if (sNode != null) {
            res.next = sNode;
        }
    }

    public static ListNode createList(ListNode head, int data) {
        ListNode pre = null, cur = head;

        while (cur != null) {
            pre = cur;
            cur = cur.next;
        }

        ListNode node = new ListNode(data);

        if (pre == null) {
            head = node;
        } else {
            pre.next = node;
        }
        
        return head;
    }

    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);

        while (cin.hasNext()) {
            int n = cin.nextInt();
            ListNode head = null;

            for (int i = 0; i < n; i++) {
                int data = cin.nextInt();
                head = createList(head, data);
            }

            reorderList(head);

            while (head != null) {
                System.out.printf("%d ", head.val);
                head = head.next;
            }
            System.out.println();
        }

        cin.close();
    }
}
