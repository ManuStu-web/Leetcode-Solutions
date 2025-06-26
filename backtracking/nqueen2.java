//Leetcode 51

package Java.backtracking;

import java.util.*;
public class nqueen2
{
    public static void main(String args[])
    {
        int n=4;
        char ansboard[][]=new char[n][n];
        for(char a[]:ansboard)
        {
            Arrays.fill(a,'.');
        }
        helper( ansboard,0);

    }

    static void helper(char ansboard[][],int c)
    {
       if(c==ansboard.length)
       {
         for(char a[]:ansboard)
         {
            System.out.println(Arrays.toString(a));
         }
         System.out.println();
         return;
       }

       for(int i=0;i<ansboard.length;i++)
       {
         if(issafe(i,c,ansboard))
         {
            ansboard[i][c]='Q';
            helper(ansboard, c+1);
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