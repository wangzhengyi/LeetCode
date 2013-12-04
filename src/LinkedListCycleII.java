import java.util.Scanner;

public class LinkedListCycleII {
    static class ListNode {
        public int val;
        public ListNode next;

        public ListNode(int x) {
            this.val = x;
            this.next = null;
        }
    }

    public static ListNode detectCycle(ListNode head) {
        if (head == null || head.next == null) {
            return null;
        }

        boolean flag = true;
        
        ListNode fast, slow;
        slow = fast = head;
        
        // judge if where has a cycle
        do {
            if (fast != null) {
                fast = fast.next;
            }
            
            if (fast != null) {
                fast = fast.next;
            }
            
            if (fast == null) {
                flag = false;
                break;
            }
            
            slow = slow.next;
        } while (fast != slow);
        
        // search for the start point
        if (flag == false) {
            return null;
        }
        
        int len;
        
        for (len = 1, slow = slow.next; slow != fast; slow = slow.next) {
            len ++;
        }
        
        fast = slow = head;
        while (len > 0) {
            fast = fast.next;
            len --;
        }
        
        while (fast != slow) {
            slow = slow.next;
            fast = fast.next;
        }
        
        return slow;
    }
    
    public static ListNode createLink(ListNode head, int data) {
        ListNode pre, cur, target;

        pre = null;
        cur = target = head;

        while (cur != null) {
            pre = cur;
            cur = cur.next;
        }
        
        while (target != null && target.val != data) {
            target = target.next;
        }
        
        if (target == null) {
            ListNode node = new ListNode(data);
            if (pre == null) {
                head = node;
            } else {
                pre.next = node;
            }
        } else {
            pre.next = target;
        }
        
        return head;
    }
    
    public static void main(String args[]) {
        Scanner cin = new Scanner(System.in);
        String s;
        String[] str;
        ListNode head, start;
        int i, data;

        while (cin.hasNext()) {
            s = cin.next();
            str = s.split(",");

            for (head = null, i = 0; i < str.length; i++) {
                data = Integer.parseInt(str[i]);
                head = createLink(head, data);
            }

            start = detectCycle(head);
            
            if (start == null) {
                System.out.println("No Circle!");
            } else {
                System.out.println(start.val);
            }
        }

        cin.close();
    }
    
}
