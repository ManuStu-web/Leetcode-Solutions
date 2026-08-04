class Solution {
    public int coinChange(int[] coins, int amount) {
        int n=coins.length;
        int [][]dp = new int[n][amount+1];
        for(int target=0;target<=amount;target++)
        {
            if(target%coins[0]==0)
            {
                dp[0][target]=target/coins[0];
            }
            else
            {
                dp[0][target]=(int)1e9;
            }
        }

        for(int i=1;i<n;i++)
        {
            for(int target=0; target<=amount;target++)
            {
                int nottake = dp[i-1][target];
                int take = (int)1e9;
                if(coins[i]<=target)
                {
                    take = 1+dp[i][target-coins[i]];
                }
                dp[i][target]=Math.min(take,nottake);
            }
        }

        int ans = dp[n-1][amount];
        return ans>=(int)1e9?-1:ans;
    }
}
