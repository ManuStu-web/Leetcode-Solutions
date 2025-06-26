//Leetcode 1672
import java.util.*;
public class rich_customer {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Enter the size rows and colms");
        int n = in.nextInt();
        int m = in.nextInt();
        int accounts[][]=new int[n][m];
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<m;j++)
            {
                accounts[i][j]=in.nextInt();
            }
        }
        int max=0;
        for(int i=0;i<n;i++)  // we can put n as arr.length for number of rows 
        {
            int sum=0;
            for(int j=0;j<m;j++) // we can put m as arr[0].length for number of coloumns 
            {
                sum=sum+accounts[i][j];
            }
            if(max<=sum)
            {
                max=sum;
            }
        }

        System.out.println("Answer" +max);
    }
    
}
