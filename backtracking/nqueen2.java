class Solution {
    public int totalNQueens(int n) {
        char ansboard[][]=new char[n][n];
       int count[]={0};
       helper(ansboard, 0, count);
       return count[0];
    }

    static void helper(char ansboard[][],int c,int count[])
    {
       if(c==ansboard.length)
       {
         count[0]=count[0]+1;
         return;
       }

       for(int i=0;i<ansboard.length;i++)
       {
         if(issafe(i,c,ansboard))
         {
            ansboard[i][c]='Q';
            helper(ansboard, c+1, count);
            ansboard[i][c]='.';
         }
       }
    }

    static boolean issafe(int row , int col , char ansboard[][])
    {
        for(int i=0;i<col;i++)
        {
            if(ansboard[row][i]=='Q')
            {
                return false;
            }
        }
        
        int r=row;
        for(int i=col ; i>=0 && r>=0 ; i-- , r-- )
        {
            if(ansboard[r][i]=='Q')
            {
                return false;
            }
        }

        int c=col;
        for(int i=row ; i<ansboard.length && c>=0 ; i++ , c-- )
        {
            if(ansboard[i][c]=='Q')
            {
                return false;
            }
        }

        return true;
    }
}
