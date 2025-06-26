//Leetcode 34

import java.util.*;
public class first_last_of_num
{
    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);

        int nums[]={5,7,7,7,8,9};
        int target=7;

        int lb=0;
        int ub=nums.length-1;

        int arr[]=new int [2];
        arr[0]=arr[1]=-1;

        while(lb<=ub)
        {
            int mid=lb+(ub-lb)/2;

            if(nums[mid]==target)
            {
                int k = mid;
                arr[1] = k;
                while (k < nums.length && nums[k] == target) {
                    arr[1] = k;
                    k++;
                }

                int l = mid;
                arr[0] = l;
                while (l >= 0 && nums[l] == target) {
                    arr[0] = l;
                    l--;
                }
                break;
            }
            else if(nums[mid]<target)
            {
                lb=mid+1;
            }
            else
            {
                ub=mid-1;
            }
        }

        for(int i=0;i<2;i++)
        {
            System.out.println(arr[i]);
        }
    }
}
