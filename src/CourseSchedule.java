
public class CourseSchedule {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
    	boolean canFinish = true;
    	int[] indegree = new int[numCourses];
    	int[][] matrix = new int[numCourses][numCourses];
    	
    	// initial data
    	for (int i = 0; i < prerequisites.length; i ++) {
    		if (matrix[prerequisites[i][0]][prerequisites[i][1]] == 1) continue;
    		indegree[prerequisites[i][1]] ++;
    		matrix[prerequisites[i][0]][prerequisites[i][1]] = 1;
    	}
    	
    	// topological sort
    	for (int i = 0; i < numCourses; i ++) {
    		for (int j = 0; j < numCourses; j ++) {
    			if (indegree[j] == 0) {
    				indegree[j] --;
    				
    				// delete node which start is j
    				for (int k = 0; k < numCourses; k ++) {
    					if (matrix[j][k] == 1) {
    						indegree[k] --;
    						matrix[j][k] = 0;
    					}
    				}
    				
    				break;
    			}
    		}
    	}
    	
    	// output result
    	for (int i = 0; i < numCourses; i ++) {
    		if (indegree[i] > 0) {
    			canFinish = false;
    			break;
    		}
    	}	
    	
    	return canFinish;
    }
}
