class Solution {
    public ArrayList<String> ratInMaze(int[][] maze) {
        int n=maze.length;
        ArrayList<String> list = new ArrayList<>();
        // code here
        if(maze[0][0]==0 || maze[n-1][n-1]==0)
        {
            return list;
        }
        
        boolean check[][] = new boolean[n][n];
        
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<n;j++)
            {
                if(maze[i][j]==0)
                {
                    check[i][j]=false;
                }
                else
                {
                    check[i][j]=true;
                }
            }
        }
        helper(maze,0,0,list,"",check);
        Collections.sort(list);
        return list;
    }
    
    public void helper(int [][]arr ,int r ,int c,ArrayList<String> list,String str,boolean check[][])
    {
        int n=arr.length;
        if(r==arr.length-1 && c==arr.length-1 && arr[r][c]==1)
        {
            list.add(str);
            return;
        }
        check[r][c]=false;
        if(r>0 && check[r-1][c]!=false)
        {
            helper(arr,r-1,c,list,str+"U",check);
        }
        
        if(c<n-1 && check[r][c+1]!=false)
        {
            helper(arr,r,c+1,list,str+"R",check);
        }
        if(r<n-1 && check[r+1][c]!=false)
        {
            helper(arr,r+1,c,list,str+"D",check);
        }
        if(c>0 && check[r][c-1]!=false)
        {
            helper(arr,r,c-1,list,str+"L",check);
        }
        check[r][c]=true;
        
       
    }
}
