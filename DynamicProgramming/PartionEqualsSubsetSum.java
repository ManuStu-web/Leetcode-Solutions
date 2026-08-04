class Solution {
    public boolean canPartition(int[] nums) {
        int total=0;
        for(int i=0;i<nums.length;i++)
        {
            total+=nums[i];
        }

        if(total%2!=0)
        {
            return false;
        }
        
        int target=total/2;
        int dp[][]=new int [nums.length][target+1];
        for(int i=0;i<nums.length;i++)
        {
            Arrays.fill(dp[i],-1);
        }

        return helper(nums.length-1,target,nums,dp);
    }

    public boolean helper(int i,int target ,int[]nums,int[][]dp )
    {
        if(target==0)
        {
            return true;
        }

        if(i==0)
        {
            return nums[i]==target;
        }

        if(dp[i][target]!=-1)
        {
            return dp[i][target]==1;
        }

        boolean nottake = helper(i-1,target,nums,dp);
        boolean take=false;
        if(nums[i]<=target)
        {
            take=helper(i-1,target-nums[i],nums,dp);
        }

        if(take||nottake)
        {
            dp[i][target]=1;
        }
        else
        {
            dp[i][target]=0;
        }

        return (take||nottake);
    }
}
