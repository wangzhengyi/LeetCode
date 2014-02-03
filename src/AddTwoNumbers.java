public class AddTwoNumbers {
    public static class ListNode {
        int val;
        ListNode next;

        public ListNode(int x) {
            this.val = x;
            this.next = null;
        }
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1 == null || l2 == null) {
            return l1 == null ? l2 : l1;
        }

        ListNode res = null, head = null, tmp;
        boolean flag = true;
        int sum, carry = 0;

        while (l1 != null && l2 != null) {
            sum = l1.val + l2.val + carry;
            carry = sum / 10;
            sum %= 10;

            if (flag) {
                res = new ListNode(sum);
                head = res;
                flag = false;
            } else {
                tmp = new ListNode(sum);
                head.next = tmp;
                head = tmp;
            }

            l1 = l1.next;
            l2 = l2.next;
        }

        while (l1 != null) {
            sum = l1.val + carry;
            carry = sum / 10;
            sum %= 10;

            tmp = new ListNode(sum);
            head.next = tmp;
            head = tmp;

            l1 = l1.next;
        }

        while (l2 != null) {
            sum = l2.val + carry;
            carry = sum / 10;
            sum %= 10;

            tmp = new ListNode(sum);
            head.next = tmp;
            head = tmp;

            l2 = l2.next;
        }
        
        while (carry > 0) {
            sum = carry % 10;
            carry /= 10;
            
            tmp = new ListNode(sum);
            head.next = tmp;
            head = tmp;
        }
        
        return res;
    }
}
