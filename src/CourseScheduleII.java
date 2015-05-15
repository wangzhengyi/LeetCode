import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class CourseScheduleII {
	public int[] findOrder(int numCourses, int[][] prerequisites) {
		if (numCourses == 0 || prerequisites == null || prerequisites.length == 0) {
			return new int[0];
		}
		
		int[] indegrees = new int[numCourses];
		List<List<Integer>> adjsGraph = new ArrayList<>(numCourses);
		
		initializeGraph(indegrees, adjsGraph, prerequisites);
		
		return solveByBFS(numCourses, indegrees, adjsGraph);
	}
	
	private void initializeGraph(int[] indegrees, List<List<Integer>> adjsGraph, int[][] prerequisites) {
		int n = indegrees.length;
		while (n -- > 0) {
			adjsGraph.add(new ArrayList<Integer>());
		}
		
		for (int[] edge : prerequisites) {
			indegrees[edge[1]] ++;
			adjsGraph.get(edge[0]).add(edge[1]);
		}
	}
	
	private int[] solveByBFS(int numCourses, int[] indegrees, List<List<Integer>> adjsGraph) {
		LinkedList<Integer> queue = new LinkedList<Integer>();
		for (int i = 0; i < numCourses; i ++) {
			if (indegrees[i] == 0) {
				queue.offer(i);
			}
		}
		
		int count = 0;
		int[] orders = new int[numCourses];
		while (!queue.isEmpty()) {
			int point = queue.poll();
			orders[count ++] = point;
			
			for (int i = 0; i < adjsGraph.get(point).size(); i ++) {
				int dependPoint = adjsGraph.get(point).get(i);
				if (-- indegrees[dependPoint] == 0) {
					queue.offer(dependPoint);
				}
			}
		}
		
		for (int i = 0, j = orders.length - 1; i < j; i ++, j --) {
			int tmp = orders[i];
			orders[i] = orders[j];
			orders[j] = tmp;
		}
		
		return count == numCourses ? orders : new int[0];
	}
}
