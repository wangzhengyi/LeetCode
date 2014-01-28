import java.util.Scanner;

public class RemoveDuplicatesFromSortedListII {
    static class ListNode {
        int val;
        ListNode next;

        public ListNode(int x) {
            this.val = x;
            this.next = null;
        }
    }

    public static ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode safeNode = new ListNode(Integer.MIN_VALUE);
        safeNode.next = head;

        ListNode pre, cur, post;
        pre = safeNode;
        cur = pre.next;

        while (cur != null) {
            if (cur.next == null) {
                break;
            }

            post = cur.next;
            boolean flag = false;

            while (post != null && post.val == cur.val) {
                flag = true;
                post = post.next;
            }

            if (flag) {
                pre.next = post;
                cur = post;
                if (cur == null) {
                    break;
                }
                post = cur.next;
            } else {
                pre = cur;
                cur = cur.next;
            }
        }

        return safeNode.next;
    }

    public static ListNode createLinkedList(int[] nodes) {
        if (nodes == null || nodes.length == 0) {
            return null;
        }

        ListNode head = new ListNode(nodes[0]);
        ListNode cur = head;

        for (int i = 1; i < nodes.length; i++) {
            ListNode tmp = new ListNode(nodes[i]);
            cur.next = tmp;
            cur = cur.next;
        }

        return head;
    }

    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);

        while (cin.hasNext()) {
            int n = cin.nextInt();
            int[] nodes = new int[n];

            for (int i = 0; i < n; i++) {
                nodes[i] = cin.nextInt();
            }

            ListNode head = createLinkedList(nodes);

            head = deleteDuplicates(head);

            while (head.next != null) {
                System.out.println(head.val);
                head = head.next;
            }
            System.out.println(head.val);
        }

        cin.close();
    }
}
