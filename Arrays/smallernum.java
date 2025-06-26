//Leetcode 1365
import java.util.*;
public class smallernum {
    Scanner in = new Scanner(System.in);

    public static void main(String args[])
    {
        Scanner in = new Scanner(System.in);
        System.out.println("ENter the size");
        int n=in.nextInt();
        int ans[]=new int[n];
        int nums[]=new int[n];
        System.out.println("Enter the elements");
        for(int i=0;i<n;i++)
        {
            nums[i]=in.nextInt();
        }
      for(int i=0;i<nums.length;i++)
      {
        int count=0;
        for(int j=0;j<nums.length;j++)
        {
            if(nums[j]<nums[i])
            {
                count++;
            }
        }
        ans[i]=count;
      }
      for(int i=0;i<nums.length;i++)
      {
        System.out.println(" " +ans[i]);
      }
    }
    
}
