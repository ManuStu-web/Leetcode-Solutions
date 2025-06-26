package Java.backtracking;

import java.util.*;
public class suduko
{
    public static void main(String[] args) 
    {
        char board[][]={
    {'5','3','.','.','7','.','.','.','.'},
    {'6','.','.','1','9','5','.','.','.'},
    {'.','9','8','.','.','.','.','6','.'},
    {'8','.','.','.','6','.','.','.','3'},
    {'4','.','.','8','.','3','.','.','1'},
    {'7','.','.','.','2','.','.','.','6'},
    {'.','6','.','.','.','.','2','8','.'},
    {'.','.','.','4','1','9','.','.','5'},
    {'.','.','.','.','8','.','.','7','9'}};

    helper(board, 0, 0);
}
    

    static void helper(char [][]board , int row , int col)
    {
        if(col==board.length)
        {
            row++;
            col=0;
        }

        if(row==board.length)
        {
            for(char [] a:board)
            {
                System.out.println(Arrays.toString(a));
            }
            return;
        }
        

       if(board[row][col]=='.')
       {
        for(int i=1;i<10;i++)
        {
            char ch = (char)(i+'0');
            if(issafe(board,row,col , ch))
            {
                board[row][col]=ch;
                helper(board, row, col+1);
                board[row][col]='.';
            }
        }
       }
       else
       {
        helper(board, row, col+1);
       }

    }

    static boolean issafe(char [][]board, int row , int col,char ch)
    {
        char ele=ch;
       for(int i=0;i<board.length;i++)
       {
         if(board[row][i]==ele)
         {
            return false;
         }
       }

       for(int j=0;j<board.length;j++)
       {
        if(board[j][col]==ele)
        {
            return false;
        }
       }

       int sr = (row / 3) * 3;
       int sc = (col / 3) * 3;
       
    //    int sr, sc;
    //    if (row >= 0 && row <= 2)
    //        sr = 0;
    //    else if (row >= 3 && row <= 5)
    //        sr = 3;
    //    else
    //        sr = 6;

    //    if (col >= 0 && col <= 2)
    //        sc = 0;
    //    else if (col >= 3 && col <= 5)
    //        sc = 3;
    //    else
    //        sc = 6;

       for (int i = sr; i < sr + 3; i++) 
       {
           for (int j = sc; j < sc + 3; j++) 
           {
               if (board[i][j] == ele) 
               {
                   return false;
               }
           }
       }

       return true;
    }
}