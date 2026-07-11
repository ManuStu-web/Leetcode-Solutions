class Solution {
    public boolean isBipartite(int[][] graph) {
        int V=graph.length;
        int color[]=new int[V];
        for(int i=0;i<V;i++) color[i]=-1;
        for(int i=0;i<V;i++)
        {
            if(color[i]==-1)
            {
                if(!dfs(i,0,color,graph))
                {
                    return false;
                }
            }
        }

        return true;
    }

    public boolean dfs(int node , int col ,int[] color,int[][]graph)
    {
        color[node]=col;

        for(int neigh:graph[node])
        {
            if(color[neigh]==-1)
            {
               if(!dfs(neigh,1-col,color,graph))
               {
                return false;
               }
            }
            else if(color[neigh]==col)
            {
                return false;
            }
        }

        return true;
    }
}
