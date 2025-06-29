class Solution {
    public boolean isValidSudoku(char[][] board) 
    {
         return helper(board,0,0);
    }

     public static boolean helper(char[][]board , int row , int col)
    {
          if(row==8 && col==9)
          {
            return true;
          }
          
          if(col==9)
          {
            row+=1;
            col=0;
          }
          
          if(board[row][col]!='.')
          {
            char ch=board[row][col];
           if(issafe(board,row,col,ch))
           { 
             return helper(board, row, col+1);
           }
           else
           {
             return false;
           } 
          }
          else
          {
            return helper(board, row, col+1);
          }
    }

    public static boolean issafe(char[][]board,int row ,int col,char ch)
    {
        for(int i=0;i<9;i++)
        {
          if(i!=col && board[row][i]==ch)
          {
            return false;
          }
        }

        for(int j=0;j<9;j++)
        {
          if(j!=row && board[j][col]==ch)
          {
            return false;
          }
        }

        int sr = (row/3)*3;
        int sc = (col/3)*3;

        for(int i=sr;i<sr+3;i++)
        {
          for(int j=sc;j<sc+3;j++)
          {
            if((i!=row || j!=col)&&board[i][j]==ch)
            {
              return false;
            }
          }
        }

        return true;
    }
}
