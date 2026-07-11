class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        // Step 1: Build adjacency list
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            adj.add(new ArrayList<>());
        }
        
        int[] indegree = new int[numCourses];
        for (int[] pre : prerequisites) {
            adj.get(pre[1]).add(pre[0]); // edge: pre[1] -> pre[0]
            indegree[pre[0]]++;          // increase indegree of course
        }

        // Step 2: Initialize queue with nodes having indegree 0
        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if (indegree[i] == 0) {
                q.offer(i);
            }
        }

        // Step 3: Perform BFS (Topological Sort)
        int[] ans = new int[numCourses];
        int idx = 0;
        while (!q.isEmpty()) {
            int node = q.poll();
            ans[idx++] = node;

            for (int it : adj.get(node)) {
                indegree[it]--;
                if (indegree[it] == 0) {
                    q.offer(it);
                }
            }
        }

        // Step 4: Check if all courses are included
        if (idx == numCourses) {
            return ans;
        } else {
            return new int[0]; // cycle detected
        }
    }
}
