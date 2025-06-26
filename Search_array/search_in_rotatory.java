//Leetcode 33
public class search_in_rotatory 
{
    public static void main(String[] args) 
    {
        int arr[]={1};
        int target=1;

        int low=0;
        int high=arr.length-1;

        while(low<high)
        {
            int mid=low+(high-low)/2;
            if(arr[mid]>arr[mid+1])
            {
                high=mid;
            }
            else {
                low=mid+1;
            }
        }
        int new_mid=low;

        //if(target >= arr[0] && target <= arr[new_mid])
        //{
            int lb=0;
            int ub=new_mid;
            while(lb<=ub)
            {
                int mid=low+(high-low)/2;
    
                if(arr[mid]==target)
                {
                    System.out.println(mid);
                    break;
                }
                else if(arr[mid]<target)
                {
                    lb=mid+1;
                }
                else if(arr[mid]>target)
                {
                    ub=mid-1;
                }
            }
        //} using if still works but it is not working in leetcode thats why i removed here 
        // array was - [1] and target was 1 so this if condition was making some error thats why i removed it

        //else
        //{
            int lb2=new_mid+1;
            int ub2=arr.length-1;
            while(lb2<=ub2)
            {
                int mid=low+(high-low)/2;
    
                if(arr[mid]==target)
                {
                    System.out.println(mid);
                    break;
                }
                else if(arr[mid]<target)
                {
                    lb2=mid+1;
                }
                else if(arr[mid]>target)
                {
                    ub2=mid-1;
                }
            }
        //}
    }
}
