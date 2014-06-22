import java.util.HashMap;


public class LRUCache {
    /**
     * 声明双向链表节点
     * 
     * @author wzy
     * 
     */
    private static class DoubleListNode {
        DoubleListNode pre;
        DoubleListNode next;
        int value;
        int key;

        public DoubleListNode(int key, int value) {
            this.key = key;
            this.value = value;
            this.pre = this.next = null;
        }
    }

    private HashMap<Integer, DoubleListNode> hashMap;

    private DoubleListNode head;

    private DoubleListNode tail;

    private int capacity;

    private int currentSize;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.currentSize = 0;
        hashMap = new HashMap<Integer, LRUCache.DoubleListNode>(capacity);
        this.head = this.tail = null;
    }

    public int get(int key) {
        DoubleListNode res = hashMap.get(key);

        if (res != null) {
            moveNodeToHead(res);
            return res.value;
        } else {
            return -1;
        }
    }

    public void set(int key, int value) {
        DoubleListNode node = hashMap.get(key);

        if (node == null) {
            node = new DoubleListNode(key, value);

            if (currentSize >= capacity) {
                hashMap.remove(tail.key);
                removeNodeFromTail();
            } else {
                currentSize++;
            }
        } else {
            node.value = value;
        }

        if (currentSize == 1) {
            head = node;
            tail = node;
        }

        moveNodeToHead(node);
        hashMap.put(key, node);
    }

    private void moveNodeToHead(DoubleListNode node) {
        if (node == head) {
            return;
        }

        if (node.next != null) {
            node.next.pre = node.pre;
        }

        if (node.pre != null) {
            node.pre.next = node.next;
        }

        if (node == tail) {
            tail = node.pre;
        }

        if (head != null) {
            node.next = head;
            head.pre = node;
        }

        head = node;
        node.pre = null;
    }

    private void removeNodeFromTail() {
        if (tail != null) {
            if (tail.pre != null) {
                tail.pre.next = null;
            } else {
                head = null;
            }

            tail = tail.pre;
        }
    }

    public static void main(String[] args) {
        LRUCache lruCache = new LRUCache(1);
        lruCache.set(2, 1);
        System.out.println(lruCache.get(2));
        lruCache.set(3, 2);
        System.out.println(lruCache.get(2));
        System.out.println(lruCache.get(3));
    }
}
