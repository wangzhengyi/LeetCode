
public class DeleteNodeInALinkedList {
	private class ListNode {
		public int val;
		public ListNode next;
		public ListNode(int x) {
			this.val = x;
		}
	}
	
    public void deleteNode(ListNode node) {
    	if (node == null || node.next == null) return;
    	
    	node.val = node.next.val;
    	node.next = node.next.next;
    }
}
