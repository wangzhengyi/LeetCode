public class IntersectionOfTwoLinkedLists {
	public static class ListNode {
		int val;
		ListNode next;

		public ListNode(int x) {
			this.val = x;
			this.next = null;
		}
	}

	public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
		int lenA, lenB;
		ListNode tmpA, tmpB;
		
		for (lenA = 0, tmpA = headA; tmpA != null; tmpA = tmpA.next) {
			lenA ++;
		}
		
		for (lenB = 0, tmpB = headB; tmpB != null; tmpB = tmpB.next) {
			lenB ++;
		}
		
		while (lenA > lenB) {
			headA = headA.next;
			lenA --;
		}
		
		while (lenB > lenA) {
			headB = headB.next;
			lenB --;
		}
		
		while (headA != null && headB != null) {
			if (headA == headB) {
				return headA;
			}
			
			headA = headA.next;
			headB = headB.next;
		}
		
		return null;
	}

}
