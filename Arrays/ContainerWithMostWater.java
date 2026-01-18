class Solution {
    public int maxArea(int[] height) 
    {
        int x=0;
        int y=height.length-1;
        int maxAmt=0;

        while(x<y)
        {
            int less = Math.min(height[x],height[y]);
            int diff = y-x;
            int currAmt = less*diff;

            maxAmt = Math.max(maxAmt,currAmt);

            if(height[x]<=height[y])
            {
                x++;
            }
            else
            {
                y--;
            }
        }

        return maxAmt;
    }
}
