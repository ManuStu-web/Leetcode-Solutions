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
    public void solve(char[][] board) {
        int n = board.length;
        int m= board[0].length;
        int notX[][] = new int[n][m];
        Queue<Pair> q = new LinkedList<>();

        for(int i=0;i<m;i++)
        {
            if(board[0][i]=='O')
            {
                notX[0][i]=1;
                q.offer(new Pair(0,i));
            }

            if(board[n-1][i]=='O')
            {
                notX[n-1][i]=1;
                q.offer(new Pair(n-1,i));
            }
        }

        for(int i=1;i<n-1;i++)
        {
            if(board[i][0]=='O')
            {
                notX[i][0]=1;
                q.offer(new Pair(i,0));
            }

            if(board[i][m-1]=='O')
            {
                notX[i][m-1]=1;
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
                int ncol = col+delcol[i];

                if(nrow>=0 && nrow<n && ncol>=0 && ncol<m && board[nrow][ncol]=='O' && notX[nrow][ncol]==0)
                {
                    notX[nrow][ncol]=1;
                    q.offer(new Pair(nrow,ncol));
                }
            }
        }

        for(int i=0;i<n;i++)
        {
            for(int j=0;j<m;j++)
            {
                if(notX[i][j]==0 && board[i][j]=='O')
                {
                    board[i][j]='X';
                }
            }
        }

    }
}
