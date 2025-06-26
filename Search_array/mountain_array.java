//Leetcode 852

public class mountain_array 
{
    static int msearch(int a[])
    {
        int low=0;
        int high=a.length-1;

        while(low<=high)
        {
            int mid=(low+high)/2;
            if(a[mid]>a[mid+1])
            {
                high=mid;
            }
            else if(a[mid]<a[mid+1])
            {
                low=mid+1;
            }
        }
        return low;

    }
  public static void main(String args[])
  {
    int a[]={0,1,2,0};
    int ans=msearch(a);

    System.out.println(ans);
    
  }   
}
