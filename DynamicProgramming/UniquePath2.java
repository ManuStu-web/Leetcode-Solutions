class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m= obstacleGrid.length;
        int n = obstacleGrid[0].length;
        int dp[][] = new int[m][n];
        for(int i=0;i<m;i++)
        {
            Arrays.fill(dp[i],-1);
        }
        return helper(m-1,n-1,dp,obstacleGrid);
    }

    public int helper(int i,int j,int dp[][],int mat[][])
    {
        if(i==0 && j==0)
        {
            return mat[0][0]==1?0:1;
        }

        if(i<0 || j<0)
        {
            return 0;
        }

        if(i>=0 && j>=0 && mat[i][j]==1)
        {
            return 0;
        }

        if(dp[i][j]!=-1)
        {
            return dp[i][j];
        }
         
         int up = helper(i-1,j,dp,mat);
         int left = helper(i,j-1,dp,mat);

        return dp[i][j]=up+left;
    }
}
