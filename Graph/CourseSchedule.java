class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        if (numCourses == 0 || prerequisites.length == 0) {
            return true;
        }
        boolean[] visited = new boolean[numCourses]; 
        boolean[] pathVisited = new boolean[numCourses];

        for (int i = 0; i < numCourses; i++) {
            if (!visited[i]) {
                if (helper(i, prerequisites, visited, pathVisited)) {
                    return false; 
                }
            }
        }
        
        return true;
    }

    public boolean helper(int currentCourse, int[][] prerequisites, boolean[] visited, boolean[] pathVisited) {
        visited[currentCourse] = true;
        pathVisited[currentCourse] = true;

        for (int i = 0; i < prerequisites.length; i++) {
            if (prerequisites[i][1] == currentCourse) {
                int nextCourse = prerequisites[i][0];
                
                if (pathVisited[nextCourse]) {
                    return true; // Cycle detected!
                }
                
                if (!visited[nextCourse]) {
                    if (helper(nextCourse, prerequisites, visited, pathVisited)) {
                        return true; 
                    }
                }
            }
        }
        
        pathVisited[currentCourse] = false;
        
        return false;
    }
}
