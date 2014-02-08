public class ReverseNodesInKGroup {
    static class ListNode {
        int val;
        ListNode next;

        public ListNode(int x) {
            this.val = x;
            this.next = null;
        }
    }
    
    public static ListNode reverseKGroup(ListNode head, int k) {
        int count = 0;
        ListNode p = head;
        while (p != null) {
            count ++;
            p = p.next;
        }
        
        // special case
        if (count < k || k == 1) {
            return head;
        }
        
        // loop count
        int loopCount = count / k;
        
        // local variable
        ListNode safeNode = new ListNode(Integer.MAX_VALUE);
        safeNode.next = head;
        
        ListNode pre = safeNode;
        ListNode cur = head;
        
        for (int i = 0; i < loopCount; i ++) {
            ListNode tmp = reverseK(cur, k);
            pre.next = tmp;
            
            ListNode tmpPre = null;
            ListNode tmpCur = tmp;
            
            for (int j = 0; j < k; j ++) {
                tmpPre = tmpCur;
                tmpCur = tmpCur.next;
            }
            
            pre = tmpPre;
            cur = tmpCur;
        }
        
        return safeNode.next;
    }
    
    public static ListNode reverseK(ListNode head, int k) {
        ListNode pre = null;
        ListNode cur = head;
        ListNode post = null;
        
        for (; k > 0 && cur != null; k --) {
            post = cur.next;
            
            cur.next = pre;
            pre = cur;
            cur = post;            
        }     
        head.next = cur;
        
        return pre;
    }
}
