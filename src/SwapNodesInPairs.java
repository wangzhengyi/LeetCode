import java.util.Scanner;

public class SwapNodesInPairs {
    static class ListNode {
        public int val;
        public ListNode next;

        public ListNode(int x) {
            this.val = x;
            this.next = null;
        }
    }

    public static ListNode swapParis(ListNode head) {
        if (head == null || head.next == null) return head;

        ListNode pre, first, second, post;
        boolean flag = true;

        pre = null;
        first = head;
        second = first.next;

        while (second != null) {
            post = second.next;

            second.next = first;
            first.next = post;

            if (flag) {
                flag = false;
                head = second;
                pre = first;
            } else {
                pre.next = second;
                pre = first;
            }


            if (post == null || post.next == null) {
                break;
            } else {
                first = post;
                second = post.next;
            }
        }

        return head;
    }

    public static ListNode createList(ListNode head, int data) {
        ListNode pre, cur, node;

        pre = null;
        cur = head;

        while (cur != null) {
            pre = cur;
            cur = cur.next;
        }

        node = new ListNode(data);

        if (pre == null) {
            head = node;
        } else {
            pre.next = node;
        }

        return head;
    }

    public static void printLinkList(ListNode head) {
        while (head != null) {
            System.out.printf("%d ", head.val);
            head = head.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int i, n;
        ListNode head = null;
        Scanner cin = new Scanner(System.in);

        while (cin.hasNext()) {
            n = cin.nextInt();

            for (i = 0, head = null; i < n; i++) {
                head = createList(head, cin.nextInt());
            }

            head = swapParis(head);

            printLinkList(head);
        }

        cin.close();
    }

}
