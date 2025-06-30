class Solution {
    public int[][] generateMatrix(int n) 
    {
      int a[][]=new int[n][n];
      int l=0,t=0,r=n-1,b=n-1;
      int count=1;
      
      while(l<=r && t<=b && count<=n*n)
      {
        for(int i=l;i<=r;i++)
        {
          a[l][i]=count;
          count++;
        }
        t++;

        for(int i=t;i<=b;i++)
        {
            a[i][r]=count;
            count++;
        }
        r--;

        for(int i=r;i>=l;i--)
        {
            a[b][i]=count;
            count++;
        }
        b--;

        for(int i=b;i>=t;i--)
        {
           a[i][l]=count;
           count++;
        }
        l++;
      }

      return a;

    }
}
