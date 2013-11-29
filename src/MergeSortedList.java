import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;


public class MergeSortedList {
    static class ListNode {
        public int val;
        public ListNode next;

        public ListNode(int x) {
            this.val = x;
            this.next = null;
        }
    }

    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode node, p = null, l3 = null;

        if (l1 == null) {
            l3 = l2;
        } else if (l2 == null) {
            l3 = l1;
        } else {
            while (l1 != null && l2 != null) {
                if (l1.val <= l2.val) {
                    node = l1;
                    l1 = l1.next;
                } else {
                    node = l2;
                    l2 = l2.next;
                }

                if (l3 == null) {
                    l3 = node;
                    p = l3;
                } else {
                    p.next = node;
                    p = node;
                }
            }

            if (l1 != null) {
                node = l1;
                l1 = l1.next;
                p.next = node;
                p = node;
            }

            if (l2 != null) {
                node = l2;
                l2 = l2.next;
                p.next = node;
                p = node;
            }
        }

        return l3;
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

    public static void main(String[] args) {
        int i, n, m, data;
        ListNode l1, l2, l3;
        ArrayList<Integer> al1 = new ArrayList<Integer>();
        ArrayList<Integer> al2 = new ArrayList<Integer>();
        Scanner cin = new Scanner(System.in);

        while (cin.hasNext()) {
            n = cin.nextInt();
            m = cin.nextInt();

            for (i = 0; i < n; i++) {
                al1.add(cin.nextInt());
            }

            for (i = 0; i < m; i++) {
                al2.add(cin.nextInt());
            }

            Iterator<Integer> itor1 = al1.iterator();
            l1 = null;
            while (itor1.hasNext()) {
                data = itor1.next();
                l1 = createList(l1, data);
            }

            Iterator<Integer> itor2 = al2.iterator();
            l2 = null;
            while (itor2.hasNext()) {
                data = itor2.next();
                l2 = createList(l2, data);
            }

            l3 = mergeTwoLists(l1, l2);
            while (l3 != null) {
                System.out.printf("%d ", l3.val);
                l3 = l3.next;
            }
            System.out.println();
        }

        cin.close();
    }
}
