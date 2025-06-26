//Leetcode 1480
import java.util.*;
public class running_sum
{
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Enter the Size");
        int n=in.nextInt();
        int runningSum[] = new int[n];
        int nums[]=new int[n];
        System.out.println("Enter the elements");
        for(int i=0;i<n;i++)
        {
            nums[i]=in.nextInt();
        }
        int sum=0;
         for(int i=0;i<n;i++)
         {
            sum=sum+nums[i];
            runningSum[i]=sum;
         }

         for(int i=0;i<n;i++)
         {
            System.out.print(" "+runningSum[i]);
         }

    }
}