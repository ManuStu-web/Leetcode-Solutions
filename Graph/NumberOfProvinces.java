class Solution {
    public int findCircleNum(int[][] isConnected) {
        ArrayList<ArrayList<Integer>> adjList = new ArrayList<>();
        int n =isConnected.length;
        for(int i=0;i<n;i++)
        {
            adjList.add(new ArrayList<>());
        }

        for(int i=0;i<n;i++)
        {
           for(int j=0;j<isConnected[i].length;j++)
           {
                if(isConnected[i][j]==1)
                {
                    adjList.get(i).add(j);
                }
           }
        }

        int vis[] = new int[n];
        int count=0;
        for(int i=0;i<n;i++)
        {
            if(vis[i]==0)
            {
                count++;
                dfs(i,vis,adjList);
            }
        }

        return count;
    }

    public void dfs(int node , int vis[] , ArrayList<ArrayList<Integer>> adjList  )
    {
        vis[node]=1;
        for(int i:adjList.get(node))
        {
            if(vis[i]==0)
            {
                dfs(i,vis,adjList);
            }
        }
    }
}
