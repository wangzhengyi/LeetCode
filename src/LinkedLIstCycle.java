import java.util.Scanner;

public class LinkedLIstCycle {
	static class ListNode {
		public int val;
		public ListNode next;

		public ListNode(int x) {
			this.val = x;
			this.next = null;
		}
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

	public static boolean hasCycle(ListNode head) {
		ListNode fast, slow;
		
		fast = slow = head;
		
		do {
			if (fast != null) {
				fast = fast.next;
			}
			
			if (fast != null) {
				fast = fast.next;
			}
			
			if (fast == null) {
				return false;
			}
			slow = slow.next;
		} while (fast != slow);
		
		return true;
	}

	public static void main(String args[]) {
		Scanner cin = new Scanner(System.in);
		String s;
		String[] str;
		ListNode head;
		int i, data;
		boolean flag;

		while (cin.hasNext()) {
			s = cin.next();
			str = s.split(",");

			for (head = null, i = 0; i < str.length; i++) {
				data = Integer.parseInt(str[i]);
				head = createLink(head, data);
			}

			flag = hasCycle(head);

			if (flag) {
				System.out.println("cycle");
			} else {
				System.out.println("no cycle");
			}
		}

		cin.close();
	}
}
