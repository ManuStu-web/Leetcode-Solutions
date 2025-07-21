class Solution {
    public int[] findMissingAndRepeatedValues(int[][] grid) 
    {
        int ans[]=new int[2];
        int n =grid.length;
        int save[]=new int[n*n];
        int m=0;
        for(int i=0;i<grid.length;i++)
        {
            for(int j=0;j<grid.length;j++)
            {
                save[m]=grid[i][j];
                m++;
            }
        }

        Arrays.sort(save);
        boolean Fflag=false;
        boolean Sflag=false;

        for(int i=1;i<save.length;i++)
        {
            if(Fflag==false && save[i-1]==save[i])
            {
                ans[0]=save[i];
                Fflag=true;
            }
 
            if(Sflag==false)
            {
               if(save[0]!=1)
               {
                Sflag=true;
                ans[1]=1;
               }

              if(save[save.length-1]!=n*n)
               {
                Sflag=true;
                ans[1]=n*n;
               }

              if((save[i]-save[i-1])>1)
               {
                Sflag=true;
                ans[1]=save[i]-1;
               }
            }
            

            if(Sflag&&Fflag)
            {
                return ans;
            }
        }

        return ans;
    }
}
