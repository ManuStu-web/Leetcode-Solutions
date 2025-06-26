//Leetcode - 1920
import java.util.*;
public class arraypermu 
{
    public static void main(String[] args) 
    {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int nums[] = new int[n];
        int ans[] = new int[n];

        System.out.println("Enter the elements");
        for(int i=0;i<n;i++)
        {
            nums[i]=in.nextInt();
        }
        
        for(int i=0;i<n;i++)
        {
           int k=nums[i];
            ans[i]=nums[k];
        }
          System.out.println("Here:");
        for(int i=0;i<n;i++)
        {
            System.out.print(" "+ans[i]);
        }
    }
    
}
