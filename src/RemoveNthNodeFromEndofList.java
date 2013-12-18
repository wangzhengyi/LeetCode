import java.util.Scanner;


public class RemoveNthNodeFromEndofList {
    static class ListNode {
        public int val;
        public ListNode next;

        public ListNode(int x) {
            this.val = x;
            this.next = null;
        }
    }

    public static ListNode createList(ListNode head, int data) {
        ListNode pre, cur, tmp;

        pre = null;
        cur = head;

        while (cur != null) {
            pre = cur;
            cur = cur.next;
        }

        tmp = new ListNode(data);

        if (pre == null) {
            head = tmp;
        } else {
            pre.next = tmp;
        }

        return head;
    }

    public static void printList(ListNode head) {
        if (head == null) {
            System.out.println("Empty LinkList!");
        }
        
        while (head != null) {
            if (head.next == null) {
                System.out.printf("%d\n", head.val);
            } else {
                System.out.printf("%d ", head.val);
            }
            head = head.next;
        }
    }

    public static ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode pre, first, second;
        int i;
        
        // initial variable
        pre = null;
        first = second = head; 
        
        // search Nth node from end
        for (i = 0; i < n && second != null; i ++) {
            second = second.next;
        }
        
        while (second != null) {
            pre = first;
            first = first.next;
            second = second.next;
        }
        
        // delete Nth Node
        if (pre == null) {
            head = head.next;
        } else {
            pre.next = first.next;
        }
        
        return head;
    }
    
    
    public static void main(String[] args) {
        int i, len, n;
        ListNode head = null;
        Scanner cin = new Scanner(System.in);

        while (cin.hasNext()) {
            len = cin.nextInt();
            for (i = 0, head = null; i < len; i++) {
                head = createList(head, cin.nextInt());
            }
            n = cin.nextInt();

            printList(head);
            
            head = removeNthFromEnd(head, n);
            
            printList(head);
        }

        cin.close();
    }
}
