import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class RemoveDuplicatesFromSortedList {
    static class ListNode {
        public int val;
        public ListNode next;
        
        public ListNode(int x) {
            this.val = x;
            this.next = null;
        }
    }
    
    public static ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        
        ListNode pre, cur;
        
        pre = head; cur = pre.next;
        
        while (cur != null) {
            if (cur.val == pre.val) {
                pre.next = cur.next;
                cur = pre.next;
            } else {
                pre = cur;
                cur = cur.next;
            }
        }
        
        return head;
    }
    
    public static ListNode createList(ListNode head, int x) {
        ListNode pre, cur, newnode;
        
        pre = null; cur = head;
        
        while (cur != null) {
            pre = cur;
            cur = cur.next;
        }
        
        newnode = new ListNode(x);
        
        if (pre == null) {
            head = newnode;
        } else {
            pre.next = newnode;
        }
        
        return head;
    }
    
    public static void printList(ListNode head) {
        if (head == null)   return;
        
        while (head != null) {
            System.out.printf("%d ", head.val);
            head = head.next;
        }
        System.out.println();
    }
    
    public static void main(String args[]) {
        int i, n, x;
        ArrayList<Integer> list= new ArrayList<Integer>();
        Scanner cin = new Scanner(System.in);
        ListNode head = null;
        
        while (cin.hasNext()) {
            // receive input data
            n = cin.nextInt();
            for (i = 0; i < n; i ++) {
                list.add(cin.nextInt());
            }
            
            // create link list
            head = null;
            Iterator<Integer> iter = list.iterator();
            while (iter.hasNext()) {
                x = iter.next();
                head = createList(head, x);
            }
            
            // delete duplicate node
            head = deleteDuplicates(head);
            
            // print list
            printList(head);
        }
        
        cin.close();
    }
}
