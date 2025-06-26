//Leetcode 442

import java.util.ArrayList;
import java.util.List;

public class allduplicate
{
    public static void main(String[] args) 
    {
        List<Integer> ans= new ArrayList<>();
        int a[]={4,3,2,7,8,2,3,1};
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

        for(i=0;i<a.length;i++)
        {
            if(a[i]!=i+1)
            {
                ans.add(a[i]);
            }
        }

        System.out.println(ans);

    }
}