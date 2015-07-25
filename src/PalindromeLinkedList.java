
public class PalindromeLinkedList {
	class ListNode {
		int val;
		ListNode next;
		public ListNode(int x) {
			this.val = x;
		}
	}
	
	// TODO:[1, 2]
    public boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null) return true;
    	
        ListNode p, q, r = null, h;
        int n, mid, i;
        
        for (n = 0, p = head; p != null; p = p.next) {
        	n ++;
        }
        
        // look for the revert point
        mid = n % 2 == 0 ? n / 2 - 1 : n / 2;
        for (p = head, q = p.next, i = 1; i <= mid; i ++) {
        	p = p.next;
        	q = q.next;
        }
        
        if (q != null && q.next != null) {
        	r = q.next;
        	q.next = null;
        }
        
        while (r != null) {
        	h = r.next;
        	r.next = q;
        	q = r;
        	r = h;
        }
        p.next = q;
        
        // check link is palindrome
        for (i = 1; i <= mid + 1 && q != null; i ++) {
        	if (head.val != q.val) {
        		return false;
        	}
        	head = head.next;
        	q = q.next;
        }
        
        return true;
    }
    
    public static void main(String[] args) {
    	PalindromeLinkedList pll = new PalindromeLinkedList();
    	
    	PalindromeLinkedList.ListNode head = pll.new ListNode(1);
    	PalindromeLinkedList.ListNode second = pll.new ListNode(2);
    	PalindromeLinkedList.ListNode third = pll.new ListNode(2);
    	PalindromeLinkedList.ListNode forth = pll.new ListNode(1);
    	head.next = second;
    	second.next = third;
    	third.next = forth;
    	
    	boolean res = pll.isPalindrome(head);
    	
    	System.out.println(res);
    }
}
