
public class RemoveLinkedListElements {
	public class ListNode {
		int val;
		ListNode next;
		public ListNode(int x) {
			this.val = x;
		}
	}
	
    public ListNode removeElements(ListNode head, int val) {
    	ListNode original = new ListNode(-1);
    	original.next = head;
    	
    	ListNode prev = original, cur = original.next;
    	
    	while (cur != null) {
    		if (cur.val == val) {
    			prev.next = cur.next;
    			cur = prev.next;
    		} else {
    			prev = cur;
    			cur = cur.next;
    		}
    	}
    	
    	return original.next;
    }
}
