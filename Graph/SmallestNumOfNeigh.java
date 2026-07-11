class Solution {
    public int findTheCity(int n, int[][] edges, int distanceThreshold) {
        int graph[][] = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i == j) {
                    graph[i][j] = 0;
                } else {
                    graph[i][j] = Integer.MAX_VALUE;
                }
            }
        }
        for (int e[] : edges) {
            graph[e[0]][e[1]] = e[2];
            graph[e[1]][e[0]] = e[2];
        }

        for (int k = 0; k < n; k++) 
        {
            for (int i = 0; i < n; i++) 
            {
                for (int j = 0; j < n; j++) 
                {
                    if (graph[i][k] != Integer.MAX_VALUE && graph[k][j] != Integer.MAX_VALUE) 
                    {
                        graph[i][j] = Math.min(graph[i][j],graph[i][k] + graph[k][j]);
                    }
                }
            }
        }

        int count[] = new int[n];
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<n;j++)
            {
                if(i!=j && graph[i][j]<=distanceThreshold)
                {
                    count[i]++;
                }
            }
        }

        int ans=-1;
        int min=(int)1e9;
        for(int i=0;i<n;i++)
        {
            if(count[i]<min)
            {
                min=count[i];
                ans=i;
            }
            else if(count[i]==min)
            {
                ans=Math.max(ans,i);
            }
        }

        return ans;

    }
}
