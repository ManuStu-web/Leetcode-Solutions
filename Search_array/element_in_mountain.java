//Leetcode 1095 --> Vs code and online compilor output is right but leetcode compilor is saying wrong answer

public class element_in_mountain 
{
    public static void main(String[] args) {
        int arr[]={1,5,2};

        int target=2;
        int low=0;
        int high=arr.length-1;

        while(low<high)
        {
            int mid=(low+high)/2;
            if(arr[mid]>arr[mid+1])
            {
                high=mid;
            }
            else {
                low=mid+1;
            }
        }
        int new_mid=low;
        System.out.println(new_mid);

        int lb=0;
        int ub=new_mid;
        int count=0;
        while(lb<=ub)
        {
            int mid=(lb+ub)/2;

            if(arr[mid]==target)
            {
                System.out.println(mid);
                count++;
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
        if(count==0)
        {
            lb=new_mid+1;
            ub=arr.length-1;
            while(lb<=ub)
            {
                int mid=(lb+ub)/2;
    
                if(arr[mid]==target)
                {
                    System.out.println(mid);
                    count++;
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
        }

        if(count==0)
        {
            System.out.println("-1");
        }
    }
    
}
