class Solution {
    public boolean exist(char[][] board, String word) 
    {
        for(int i=0;i<board.length;i++)
        {
            for(int j=0;j<board[0].length;j++)
            {
                if(board[i][j]==word.charAt(0))
                {
                    if(helper(board,word.substring(1),i,j))
                    {
                        return true;
                    }
                }
            }
        }

        return false;
    }

    public boolean helper(char[][] board,String word,int x,int y)
    {
        if(word.length()==0)
        {
            return true;
        }

        char temp = board[x][y];
        board[x][y]='.';

        boolean found = false;
        
        //right
        if(y<board[0].length-1 && board[x][y+1]==word.charAt(0))
        {
            found = helper(board,word.substring(1),x,y+1);
        }

        //down
        if(!found && x<board.length-1 && board[x+1][y]==word.charAt(0))
        {
            found = helper(board,word.substring(1),x+1,y);
        }

        //left
        if(!found && y>0 && board[x][y-1]==word.charAt(0))
        {
            found = helper(board,word.substring(1),x,y-1);
        }

        //top
        if(!found && x>0 && board[x-1][y]==word.charAt(0))
        {
            found = helper(board,word.substring(1),x-1,y);
        }

        board[x][y]=temp;
        return found;
    }
}
