class Solution {
    public int minPathSum(int[][] grid) {
        int dp[][] = new int[grid.length][grid[0].length];
        dp[0][0]=grid[0][0];
        for(int i=0;i<grid.length;i++)
        {
            for(int j=0;j<grid[0].length;j++)
            {
                if(i==0 && j==0)
                {
                    continue;
                }

                int left=(int)1e9;
                if(j-1>=0)
                {
                left=grid[i][j]+dp[i][j-1];
                }
                
                int up=(int)1e9;
                if(i-1>=0){
                up=grid[i][j]+dp[i-1][j];
                }

                dp[i][j]=Math.min(left,up);
            }
        }

        return dp[grid.length-1][grid[0].length-1];
        
    }
}
