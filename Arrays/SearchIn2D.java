class Solution {
    public boolean searchMatrix(int[][] matrix, int target) 
    {
        for(int i=0;i<matrix.length;i++)
        {
            int j=matrix[0].length-1;

            if(target>=matrix[i][0] && target<=matrix[i][j])
            {
                int low=0;
                int high=j;
                while(low<=high)
                {
                    int mid = low + (high-low)/2;
                    if(matrix[i][mid]==target)
                    {
                        return true;
                    }
                    else if(matrix[i][mid]<target)
                    {
                        low=mid+1;
                    }
                    else
                    {
                        high=mid-1;
                    }
                }

                return false;
            }
        }

        return false;
    }
}
