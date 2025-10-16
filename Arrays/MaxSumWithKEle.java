class Solution {
    public int maximizeSum(int[] nums, int k)
    {
        int maxele=0;
        int maxidx=-1;
        int sum=0;

        for(int i=0;i<nums.length;i++)
        {
            if(nums[i]>maxele)
            {
                maxele=nums[i];
                maxidx=i;
            }
        }
        while(k>0)
        {
            sum+=nums[maxidx];
            nums[maxidx]=nums[maxidx]+1;
            k--;
        }

        return maxele;
    }
}
