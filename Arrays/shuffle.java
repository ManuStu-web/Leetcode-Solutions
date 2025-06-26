//Leetcode 1470 Shuffling array
import java.util.*;
public class shuffle {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Enter the Size");
        int n=in.nextInt();
        int m=2*n;
        int nums[] = new int[m];
        int ans[] = new int[m];
        System.out.println("Enter the elements");
        for(int i=0;i<m;i++)
        {
            nums[i]=in.nextInt();
        }
        int k = m/2;
        int l=0;
        for(int i=0;i<m;i++)
        {
          if(i%2==0)
          {
            ans[i]=nums[l];
            l++;
          }
          else
          {
            ans[i]=nums[k];
            k++;
          }
        }
        for(int i=0;i<m;i++)
        {
            System.out.print(" " + ans[i]);
        }

    }
    
}
