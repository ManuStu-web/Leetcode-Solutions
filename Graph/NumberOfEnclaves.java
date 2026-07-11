class Solution {
    class Pair{
        int row;
        int col;
        Pair(int r,int c)
        {
            row=r;
            col=c;
        }
    }
    public int numEnclaves(int[][] grid) {
        int n = grid.length;
        int m= grid[0].length;
        int count=0;
        int vis[][]=new int[n][m];
        Queue<Pair> q = new LinkedList<>();

        for(int i=0;i<m;i++)
        {
            if(grid[0][i]==1 && vis[0][i]==0)
            {
                count++;
                vis[0][i]=1;
                q.offer(new Pair(0,i));
            }

            if(grid[n-1][i]==1 && vis[n-1][i]==0)
            {
                count++;
                vis[n-1][i]=1;
                q.offer(new Pair(n-1,i));
            }
        }

        for(int i=1;i<n-1;i++)
        {
            if(grid[i][0]==1 && vis[i][0]==0)
            {
                count++;
                vis[i][0]=1;
                q.offer(new Pair(i,0));
            }
            if(grid[i][m-1]==1 && vis[i][m-1]==0)
            {
                count++;
                vis[i][m-1]=1;
                q.offer(new Pair(i,m-1));
            }
        }

        int delrow[]={-1,0,1,0};
        int delcol[]={0,1,0,-1};
        while(!q.isEmpty())
        {
            Pair p = q.poll();
            int row=p.row;
            int col=p.col;

            for(int i=0;i<4;i++)
            {
                int nrow=row+delrow[i];
                int ncol=col+delcol[i];
                if(nrow>=0 && nrow<n && ncol>=0 &&ncol<m && grid[nrow][ncol]==1 && vis[nrow][ncol]==0)
                {
                    vis[nrow][ncol]=1;
                    count++;
                    q.offer(new Pair(nrow,ncol));
                }
            }
        }

        int landCount=0;
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<m;j++)
            {
                if(grid[i][j]==1)
                {
                    landCount++;
                }
            }
        }
        return landCount-count;
    }
}
