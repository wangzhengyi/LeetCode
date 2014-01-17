import java.util.ArrayList;
import java.util.Scanner;

public class MergeKSortedLists {
    static class ListNode {
        int val;
        ListNode next;

        public ListNode(int x) {
            this.val = x;
            this.next = null;
        }
    }

    public static ListNode mergeTwoLists(ListNode first, ListNode second) {
        if (first == null || second == null) {
            return first == null ? second : first;
        }

        ListNode head, tmp;

        if (first.val <= second.val) {
            head = first;
            first = first.next;
        } else {
            head = second;
            second = second.next;
        }
        tmp = head;


        while (first != null && second != null) {
            if (first.val <= second.val) {
                tmp.next = first;
                tmp = first;
                first = first.next;
            } else {
                tmp.next = second;
                tmp = second;
                second = second.next;
            }
        }

        if (first != null) {
            tmp.next = first;
        }
        
        if (second != null) {
            tmp.next = second;
        }

        return head;
    }

    public static ListNode mergeKLists(ArrayList<ListNode> lists) {
        ListNode head = null;

        if (lists == null || lists.size() == 0) {
            return head;
        }

        for (int i = 0; i < lists.size(); i ++) {
            ListNode ele = lists.get(i);
            head = mergeTwoLists(head, ele);
        }

        return head;
    }

    public static ListNode createSortedList(int[] A) {
        if (A == null || A.length == 0) {
            return null;
        }

        ListNode head = new ListNode(A[0]);
        ListNode p, q;
        p = head;
        q = null;

        for (int i = 1; i < A.length; i++) {
            q = new ListNode(A[i]);
            p.next = q;
            p = q;
        }

        return head;
    }

    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);

        while (cin.hasNext()) {
            int n = cin.nextInt();
            ArrayList<ListNode> lists = new ArrayList<MergeKSortedLists.ListNode>();

            for (int i = 0; i < n; i++) {
                int m = cin.nextInt();
                int A[] = new int[m];

                for (int j = 0; j < m; j++) {
                    A[j] = cin.nextInt();
                }

                ListNode head = createSortedList(A);

                lists.add(head);
            }

            ListNode head = mergeKLists(lists);
            
            while (head.next != null) {
                System.out.printf("%d ", head.val);
                head = head.next;
            }
            System.out.println(head.val);
        }

        cin.close();
    }
}
