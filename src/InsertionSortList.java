import java.util.ArrayList;
import java.util.Scanner;

public class InsertionSortList {
    static class ListNode {
        int val;
        ListNode next;

        public ListNode(int x) {
            this.val = x;
            this.next = null;
        }
    }

    public static ListNode insertionSortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode first = new ListNode(Integer.MIN_VALUE);
        first.next = head;

        ListNode cur, tmp, post, pre;
        cur = head.next;

        while (cur != null) {
            pre = first;
            tmp = first.next;
            post = cur.next;
            while (tmp != cur && tmp.val <= cur.val) {
                pre = tmp;
                tmp = tmp.next;
            }
            if (tmp != cur) {
                pre.next = cur;
                cur.next = tmp;
                
                while (tmp.next != cur) {
                    tmp = tmp.next;
                }
                tmp.next = post;
            }

            cur = post;
        }

        return first.next;
    }

    public static ListNode createList(ArrayList<Integer> list) {
        if (list.size() == 0) {
            return null;
        }

        ListNode head, cur;

        head = new ListNode(list.get(0));
        cur = head;

        for (int i = 1; i < list.size(); i++) {
            ListNode tmp = new ListNode(list.get(i));
            cur.next = tmp;
            cur = tmp;
        }

        return head;
    }

    public static void main(String args[]) {
        Scanner cin = new Scanner(System.in);

        while (cin.hasNext()) {
            ArrayList<Integer> list = new ArrayList<Integer>();
            int n = cin.nextInt();

            for (int i = 0; i < n; i++) {
                list.add(cin.nextInt());
            }

            ListNode head = createList(list);

            head = insertionSortList(head);

            while (head != null) {
                System.out.printf("%d ", head.val);
                head = head.next;
            }
        }

        cin.close();
    }
}
