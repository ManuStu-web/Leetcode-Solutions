class Solution {
    public void rotate(int[] nums, int k) {
        doarray(nums,k);   
    }
        public static int[] doarray(int nums[],int k)
    {
      if(k<1)
      {
        return nums;
      }
      else
      {
        int last = nums[nums.length-1];
        for(int i=nums.length-1;i>0;i--)
        {
          nums[i]=nums[i-1];
        }

        nums[0]=last;
      }

      return doarray(nums,k-1);
    }
      
}
