//Leetcode 448
import java.util.*;
public class disapperednum {
    public static void main(String[] args) {
        
        int a[]={1,1};
        int i=0;
        while(i<a.length)
        {
            int correct_idx=a[i]-1;
            if(a[i]!=a[correct_idx])
            {
                int temp=a[i];
                a[i]=a[correct_idx];
                a[correct_idx]=temp;
            }
            else{
                i++;
            }
        }

        System.out.println(Arrays.toString(a));

        for(i=0;i<a.length;i++)
        {
            if(a[i]!=i+1)
            {
                System.out.println(i+1);
            }
            else{
                continue;
            }
        }
    }
}
