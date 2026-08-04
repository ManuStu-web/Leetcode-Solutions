class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        int total=0;
        for(int x:nums)
        {
            total+=x;
        }

        if(Math.abs(target)>total)
        {
            return 0;
        }

        if((total+target)%2!=0)
        {
            return 0;
        }

        int t = (total+target)/2;
        int dp[][] = new int[nums.length][t+1];
        for(int i=0;i<nums.length;i++)
        {
            Arrays.fill(dp[i],-1);
        }

        return solve(nums.length-1,t,nums,dp);
    }

    int solve(int i,int target,int nums[],int dp[][])
    {
        if(i==0)
        {
            if(target==0 && nums[0]==0)
            {
                return 2;
            }
            if(target==0 || nums[0]==target)
            {
                return 1;
            }
            return 0;
        }

        if(dp[i][target]!=-1)
        {
            return dp[i][target];
        }
        int nottake = solve(i-1,target,nums,dp);
        int take=0;
        if(nums[i]<=target)
        {
            take=solve(i-1,target-nums[i],nums,dp);
        }

        return dp[i][target]=take+nottake;
    }
}
