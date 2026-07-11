class Solution {
    class Pair{
        int dis;
        int row;
        int col;
        Pair(int f , int s , int t)
        {
            dis=f;
            row=s;
            col=t;
        }
    }
    public int shortestPathBinaryMatrix(int[][] grid) {
        int n = grid.length;
        if(grid[0][0]!=0 || grid[n-1][n-1]!=0)
        {
            return -1;
        }
        int vis[][] = new int[n][n];

        for(int i=0;i<n;i++)
        {
            for(int j=0;j<n;j++)
            {
                vis[i][j]=Integer.MAX_VALUE;
            }
        }

        PriorityQueue<Pair> pq = new PriorityQueue<>((a,b)-> a.dis-b.dis);

        vis[0][0]=0;
        pq.offer(new Pair(0,0,0));
        int count=0;
        while(!pq.isEmpty())
        {
            Pair p = pq.poll();
            count++;
            int row = p.row;
            int col = p.col;
            int dis = p.dis;

            if(row==n-1 && col==n-1)
            {
                return dis+1;
            }

            //up
            if(row>0 && grid[row-1][col]==0)
            {
                if(vis[row-1][col]> dis+1)
                {
                    vis[row-1][col]=dis+1;
                    pq.offer(new Pair(dis+1,row-1,col));
                }
            }

            //down
            if(row<n-1 && grid[row+1][col]==0)
            {
                if(vis[row+1][col]> dis+1)
                {
                    vis[row+1][col]=dis+1;
                    pq.offer(new Pair(dis+1,row+1,col));
                }
            }

            //left
            if(col>0 && grid[row][col-1]==0)
            {
                if(vis[row][col-1]> dis+1)
                {
                    vis[row][col-1]=dis+1;
                    pq.offer(new Pair(dis+1,row,col-1));
                }
            }

            //right
            if(col<n-1 && grid[row][col+1]==0)
            {
                if(vis[row][col+1]> dis+1)
                {
                    vis[row][col+1]=dis+1;
                    pq.offer(new Pair(dis+1,row,col+1));
                }
            }

            //up left 
            if(row>0 && col>0 && grid[row-1][col-1]==0)
            {
                if(vis[row-1][col-1]> dis+1)
                {
                    vis[row-1][col-1]=dis+1;
                    pq.offer(new Pair(dis+1,row-1,col-1));
                }
            }

            //up right
            if(row>0 && col<n-1 && grid[row-1][col+1]==0)
            {
                if(vis[row-1][col+1]> dis+1)
                {
                    vis[row-1][col+1]=dis+1;
                    pq.offer(new Pair(dis+1,row-1,col+1));
                }
            }
            //down left
            if(row<n-1 && col>0 && grid[row+1][col-1]==0)
            {
                if(vis[row+1][col-1]> dis+1)
                {
                    vis[row+1][col-1]=dis+1;
                    pq.offer(new Pair(dis+1,row+1,col-1));
                }
            }

            //down right
            if(row<n-1 && col<n-1 && grid[row+1][col+1]==0)
            {
                if(vis[row+1][col+1]> dis+1)
                {
                    vis[row+1][col+1]=dis+1;
                    pq.offer(new Pair(dis+1,row+1,col+1));
                }
            }
        }
        return -1;
    }
}
