class Solution {
    public int removeDuplicates(int[] nums) {
        int ptr =0;
        for(int i=ptr+1;i<nums.length;i++)
        {
            if(nums[ptr]!=nums[i])
            {
                ptr++;
                nums[ptr]=nums[i];
                
            }
        }

        return ptr+1;
    }
}
