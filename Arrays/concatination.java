//Leetcode - 1929
import java.util.*;
public class concatination {
    public static void main(String[] args) {
        
        Scanner in = new Scanner(System.in);
        System.out.println("Enter the Size");
        int n = in.nextInt();
        int nums[]=new int[n];
        System.out.println("Enter the elements");
        for(int i=0;i<n;i++)
        {
            nums[i]=in.nextInt();
        }
        int m = 2*n;
        int ans[]= new int[m];
         int k =0;
        for(int i=0;i<n;i++)
        {
            ans[k]=nums[i];
            k++;
        }
        for(int i=0;i<n;i++)
        {
            ans[k]=nums[i];
            k++;
        }


    }
}
