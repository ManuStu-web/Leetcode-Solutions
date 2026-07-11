class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        List<List<Integer>> adjRev = new ArrayList<>();
        int indegree[]=new int[graph.length];
        for(int i=0;i<graph.length;i++)
        {
            adjRev.add(new ArrayList<>());
        }
        for(int i=0;i<graph.length;i++)
        {
            for(int j=0;j<graph[i].length;j++)
            {
                int v = graph[i][j];
                adjRev.get(v).add(i);
                indegree[i]++;
            }
        }

        Queue<Integer> q = new LinkedList<>();
        for(int i=0;i<indegree.length;i++)
        {
            if(indegree[i]==0)
            {
                q.offer(i);
            }
        }

        List<Integer> safeNodes = new ArrayList<>();
        while(!q.isEmpty())
        {
            int node = q.poll();
            safeNodes.add(node);

            for(int it:adjRev.get(node))
            {
                indegree[it]--;
                if(indegree[it]==0)
                {
                    q.offer(it);
                }
            }
        }

        Collections.sort(safeNodes);
        return safeNodes;
    }
}
