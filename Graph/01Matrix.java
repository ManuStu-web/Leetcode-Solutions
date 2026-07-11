class Solution {
    class Pair{
        int row;
        int col;
        int dis;
        Pair(int r , int c, int d)
        {
            row=r;
            col=c;
            dis=d;
        }
    }
    public int[][] updateMatrix(int[][] mat) {
        int n=mat.length;
        int m=mat[0].length;

        int vis[][] = new int[n][m];
        int dist[][] = new int[n][m];
        Queue<Pair> q = new LinkedList<>();

        for(int i=0;i<n;i++)
        {
            for(int j=0;j<m;j++)
            {
                if(mat[i][j]==0)
                {
                    q.offer(new Pair(i,j,0));
                    vis[i][j]=1;
                }
                else
                {
                    vis[i][j]=0;
                }
            }
        }

        while(!q.isEmpty())
        {
            Pair p = q.poll();
            int row = p.row;
            int col = p.col;
            int dis = p.dis;

            dist[row][col]=dis;
            //up
            if(row>0 && vis[row-1][col]==0)
            {
                vis[row-1][col]=1;
                q.offer(new Pair(row-1,col,dis+1));
            }
            //down
            if(row<n-1&& vis[row+1][col]==0)
            {
                vis[row+1][col]=1;
                q.offer(new Pair(row+1,col,dis+1));
            }
            //left
            if(col>0 && vis[row][col-1]==0)
            {
                vis[row][col-1]=1;
                q.offer(new Pair(row,col-1,dis+1));
            }
            //right
            if(col<m-1 && vis[row][col+1]==0)
            {
                vis[row][col+1]=1;
                q.offer(new Pair(row,col+1,dis+1));
            }
        }

        return dist;
    }
}
