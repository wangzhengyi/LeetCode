public class ReverseLinkedList {
	private class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
		}
	}

	public ListNode reverseList(ListNode head) {
		ListNode tNode = new ListNode(-1);
		tNode.next = head;

		ListNode prevNode, curNode, nextNode;

		prevNode = tNode;
		curNode = tNode.next;
		if (curNode == null) {
			return curNode;
		} else {
			nextNode = curNode.next;
		}

		while (curNode != null) {
			curNode.next = prevNode;
			prevNode = curNode;
			curNode = nextNode;
			if (curNode != null)
				nextNode = curNode.next;
		}

		// 删掉自加头节点
		head.next = null;

		return prevNode;
	}
}
