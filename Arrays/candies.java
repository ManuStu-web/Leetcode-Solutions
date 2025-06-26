//Leetcode 1431
import java.util.*;
public class candies
{
    public static void main(String args[])
    {
      Scanner in = new Scanner (System.in);
      System.out.println("Enter the size and then extra candies");
      int n=in.nextInt();
      int ec=in.nextInt();
      int nums[]=new int[n];
      boolean ans[]=new boolean[n];

      System.out.println("Enter the elements");
      for(int i=0;i<n;i++)
      {
        nums[i]=in.nextInt();
      }

      for(int i=0;i<n;i++)
      {
        int count=0;
        int total=nums[i]+ec;
        for(int j=0;j<n;j++)
        {
            if(total>=nums[j])
            {
                count++;
            }

            if(count==nums.length)
            {
               ans[i]=true;
            }
            else
            {
                ans[i]=false;
            }
        }
      }

      for(int i=0;i<n;i++)
      {
        System.out.print("[" + ans[i]+"]");
      }
 
    }
}