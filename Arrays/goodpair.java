//Leetcode 1512
import java.util.*;
public class goodpair
{
    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);
        System.out.println("Enter the size of the array");
        int n = in.nextInt();
         int count=0;
        int a[]= new int[n];

        System.out.println("Enter the elements of array");
        for(int i =0;i<n;i++)
        {
            a[i]=in.nextInt();
        }
        int flag=0;
        int b []=new int[n];

        for(int i =0;i<n;i++)
        {
            for(int j=0;j<n;j++)
            {
                if(a[i]==a[j] && i<j)
                {
                    count++;
                }

                if(a[i]!=a[j])
                {
                    flag=1;
                }
            }
        }

        if(flag==0)
        System.out.println("Good pairs are : "+count/2);
        else
        System.out.println("Good pairs are : " +count);
    }
}
