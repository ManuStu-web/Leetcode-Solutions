class Solution {
    public void moveZeroes(int[] nums) {
        int x = 0;
        int y=1;

        while(y<nums.length)
        {
           if(nums[x]!=0 && nums[y]!=0)
           {
             x=y+1;
             y=x+1;
           }
           else if(nums[x]!=0 && nums[y]==0)
           {
            x=y;
            y++;
           }
           else if(nums[y]==0)
           {
            y++;
           }
           else if(nums[x]==0 && nums[y]!=0)
           {
            int temp = nums[y];
            nums[y]=nums[x];
            nums[x]=temp;

            x++;
            y++;
           }
        }

    }
}
