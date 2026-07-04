class Solution {
    public int candy(int[] ratings) {
        int left[] = new int[ratings.length];
        left[0]=1;


        for(int i=1;i<ratings.length;i++)
        {
            if(ratings[i-1]<ratings[i])
            {
                left[i]=left[i-1]+1;
            }
            else
            {
                left[i]=1;
            }
        }

        for(int i=ratings.length-2;i>=0;i--)
        {
            if(ratings[i+1]<ratings[i])
            {
                left[i]=Math.max(left[i],left[i+1]+1);
            }
        }

        int ans=0;
        for(int i=0;i<ratings.length;i++)
        {
            ans+=left[i];
        }

        return ans;
        
    }
}
