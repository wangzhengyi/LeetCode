
public class CopyListWithRandomPointer {
    static class RandomListNode {
        int label;
        RandomListNode next, random;
        
        public RandomListNode(int x) {
            this.label = x;
        }
    }
    
    public RandomListNode copyRandomList(RandomListNode head) {
        // special case
       if (head == null) {
           return null;
       }
       
       RandomListNode p, tmp, resHead = null;
       
       p = head;
       while (p != null) {
           tmp = new RandomListNode(p.label);
           tmp.next = p.next;
           p.next = tmp;
           if (resHead == null) {
               resHead = tmp;
           }
           p = p.next.next;
       }
       
       p = head;
       while (p != null) {
           p.next.random = p.random == null ? null : p.random.next;
           p = p.next.next;
       }
       
       p = head;
       while (p != null) {
           tmp = p.next;
           p.next = p.next.next;
           tmp.next = p.next == null ? null : p.next.next;
           p = p.next;
       }
       
       return resHead;
    }
}
