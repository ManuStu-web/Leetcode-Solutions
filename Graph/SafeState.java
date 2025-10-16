class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        List<Integer> list = new ArrayList<>();
        boolean vis[] = new boolean[graph.length];
        boolean pathVis[] = new boolean[graph.length];
        boolean isSafe[] = new boolean[graph.length];

        for (int i = 0; i < graph.length; i++) {
            if (!vis[i]) {
                dfs(i, graph, vis, pathVis, isSafe);
            }
        }

        for (int i = 0; i < graph.length; i++) {
            if (isSafe[i]) {
                list.add(i);
            }
        }

        return list;
    }

    public boolean dfs(int curr, int[][] graph, boolean vis[], boolean pathVis[], boolean isSafe[]) {
        vis[curr] = true;
        pathVis[curr] = true;

        for (int i : graph[curr]) {
            if (!vis[i]) {
                if (!dfs(i, graph, vis, pathVis, isSafe)) {
                    return false;
                }

            } else if (pathVis[i] || !isSafe[i]) {
                return false;
            }
        }

        isSafe[curr] = true;
        pathVis[curr] = false;
        return true;
    }

}
