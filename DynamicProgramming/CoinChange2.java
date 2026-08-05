class Solution {
    public int change(int amount, int[] coins) {
        int n = coins.length;
        int dp[][] = new int[n][amount+1];

        for(int tar=0;tar<=amount;tar++)
        {
            if(tar%coins[0]==0)
            {
                dp[0][tar]=1;
            }
            else
            {
                dp[0][tar]=0;
            }
        }

        for(int i=1;i<n;i++)
        {
            for(int t=0;t<=amount;t++)
            {
                int nottake = dp[i-1][t];
                int take=0;
                if(coins[i]<=t)
                {
                    take=dp[i][t-coins[i]];
                }

                dp[i][t]=take+nottake;
            }
        }

        return dp[n-1][amount];
    }
}
