//Leetcode 136

import java.util.*;
public class pairs 
{
    public static void main(String args[])
    {
        Scanner in = new Scanner(System.in);
        int arr[]={2,2,1};

        int count=0;
        int ans=0;

        int a[]=new int[arr.length];
        
        for(int i=0;i<arr.length;i++)
        {
            int sum=count-1;
            for(int j=0;j<arr.length;j++)
            {
                if(arr[i]==arr[j])
                {
                    count++;
                    break;
                }
            }

            if(count==sum+2)
            {
              sum++;
            }
            else
            {
                ans=arr[i];
                break;
            }
        }
    }
}
