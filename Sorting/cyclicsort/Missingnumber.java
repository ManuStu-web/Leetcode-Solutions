//Leetcode 268
public class Missingnumber 
{
    public static void main(String[] args) 
    {
        int a[]={5,4,0,3,2};
        int i=0;
        while(i<a.length)
        {
            int correct_idx=a[i];
            if(a[i]<a.length && a[i]!=i)
            {
                int temp=a[i];
                a[i]=a[correct_idx];
                a[correct_idx]=temp;
            }
            else{
                i++;
            }
        }
        
        int count=0;
        i=0;
        for(i=0;i<a.length;i++)
        {
            if(a[i]!=i)
            {
                System.out.println("Mising Element is: " + i);
                count++;
            }
            else
            {
                continue;
            }
        }

        if(count==0)
        {
            System.out.println("Missing Element is: " + a.length);
        }
    }
}
