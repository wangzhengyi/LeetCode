import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class CloneGraph {
	private static class UndirectedGraphNode {
		int label;
		List<UndirectedGraphNode> neighbors;

		private UndirectedGraphNode(int x) {
			this.label = x;
			this.neighbors = new ArrayList<UndirectedGraphNode>();
		}
	}

	public static UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
		if (node == null) {
			return null;
		}

		LinkedList<UndirectedGraphNode> queue = new LinkedList<UndirectedGraphNode>();
		queue.addLast(node);

		UndirectedGraphNode head = new UndirectedGraphNode(node.label);
		HashMap<UndirectedGraphNode, UndirectedGraphNode> map = new HashMap<UndirectedGraphNode, UndirectedGraphNode>();
		map.put(node, head);

		while (!queue.isEmpty()) {
			UndirectedGraphNode tmpNode = queue.pollFirst();

			for (UndirectedGraphNode neighborNode : tmpNode.neighbors) {
				if (map.containsKey(neighborNode)) {
					map.get(tmpNode).neighbors.add(map.get(neighborNode));
				} else {
					UndirectedGraphNode copy = new UndirectedGraphNode(neighborNode.label);
					map.put(neighborNode, copy);
					map.get(tmpNode).neighbors.add(copy);
					queue.add(neighborNode);
				}
			}
		}

		return head;
	}
}
