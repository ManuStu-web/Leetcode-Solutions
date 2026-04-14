class Solution {
    public boolean checkValidGrid(int[][] grid) {
        if(grid[0][0]!=0) return false;
        if(grid.length==1) return true;
        return checkMove(grid , 0 ,0,0);
    }

    public boolean checkMove(int [][]grid, int x , int r , int c )
    {
        int n=grid.length;
        if(x==(n*n-1))
        {
            return true;
        }

        if(r>1 && c<n-1)
        {
            if(grid[r-2][c+1]==x+1)
            {
                return checkMove(grid,x+1,r-2,c+1);
            }
        }
        if(r>1 && c>0)
        {
            if(grid[r-2][c-1]==x+1)
            {
                return checkMove(grid,x+1,r-2,c-1);
            }
        }
        if(r>0 && c<n-2)
        {
            if(grid[r-1][c+2]==x+1)
            {
                return checkMove(grid,x+1,r-1,c+2);
            }
        }
        if(r<n-1 && c<n-2)
        {
            if(grid[r+1][c+2]==x+1)
            {
                return checkMove(grid,x+1,r+1,c+2);
            }
        }
        if(r<n-2 && c<n-1)
        {
            if(grid[r+2][c+1]==x+1)
            {
                return checkMove(grid,x+1,r+2,c+1);
            }
        }
        if(r<n-2 && c>0)
        {
            if(grid[r+2][c-1]==x+1)
            {
                return checkMove(grid,x+1,r+2,c-1);
            }
        }
        if(r<n-1 && c>1)
        {
            if(grid[r+1][c-2]==x+1)
            {
                return checkMove(grid,x+1,r+1,c-2);
            }
        }
        if(r>0 && c>1)
        {
            if(grid[r-1][c-2]==x+1)
            {
                return checkMove(grid,x+1,r-1,c-2);
            }
        }

        return false;
    }
}
