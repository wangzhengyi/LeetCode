import java.util.HashMap;

public class LRUCache {
	private HashMap<Integer, DoubleListNode> mHashMap;
	private DoubleListNode head;
	private DoubleListNode tail;
	private int capacity;
	private int currentsize;

	public LRUCache(int capacity) {
		this.capacity = capacity;
		this.currentsize = 0;
		this.mHashMap = new HashMap<Integer, DoubleListNode>();
		this.head = this.tail = null;
	}

	public int get(int key) {
		if (mHashMap.containsKey(key)) {
			DoubleListNode tNode = mHashMap.get(key);
			if (tNode == tail) {
				if (currentsize > 1) {
					removeNodeFromTail();
					moveNodeToHead(tNode);
				}
			} else if (tNode == head) {
				// do nothing
			} else {
				tNode.pre.next = tNode.next;
				tNode.next.pre = tNode.pre;
				moveNodeToHead(tNode);
			}
			return mHashMap.get(key).value;
		} else {
			return -1;
		}
	}

	private void removeNodeFromTail() {
		tail = tail.pre;
		if (tail != null) {
			tail.next = null;
		}
	}

	private void moveNodeToHead(DoubleListNode node) {
		head.pre = node;
		node.next = head;
		node.pre = null;
		head = node;
	}

	public void set(int key, int value) {
		if (mHashMap.containsKey(key)) {
			// 更新HashMap中对应的值，并将key对应的Node移至队头
			DoubleListNode tNode = mHashMap.get(key);
			tNode.value = value;
			if (tNode == tail) {
				if (currentsize > 1) {
					removeNodeFromTail();
					moveNodeToHead(tNode);
				}
			} else if (tNode == head) {
				// do nothing
			} else {
				tNode.pre.next = tNode.next;
				tNode.next.pre = tNode.pre;
				moveNodeToHead(tNode);
			}

			mHashMap.put(key, tNode);
		} else {
			DoubleListNode node = new DoubleListNode(key, value);
			mHashMap.put(key, node);
			if (currentsize == 0) {
				head = tail = node;
				currentsize += 1;
			} else if (currentsize < capacity) {
				moveNodeToHead(node);
				currentsize += 1;
			} else {
				// 删除tail节点，并且增加一个head节点
				mHashMap.remove(tail.key);
				removeNodeFromTail();

				// 增加头节点
				moveNodeToHead(node);
			}
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

	private static class DoubleListNode {
		public DoubleListNode pre;
		public DoubleListNode next;
		public int key;
		public int value;

		public DoubleListNode(int key, int value) {
			this.key = key;
			this.value = value;
			this.pre = this.next = null;
		}
	}

}
