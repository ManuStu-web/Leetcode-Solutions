//Leetcode 410
public class split_Array_sum 
{
    public static void main(String[] args) 
    {
        int a[]={1,2,3,4,5};
        int n=a.length-1;
        int b[]=new int[n];
        int i=1;
        int z=0;
        int lb1=0;
        int ub1=n;
        do
        {
            ub1=n-i;
            int lb2=ub1+1;
            int ub2=n;

            int sum1=0;
            int sum2=0;

            for(int j=lb1;j<=ub1;j++)
            {
                sum1+=a[j];
            }

            for(int k=lb2;k<=ub2;k++)
            {
                sum2+=a[k];
            }

            System.out.println(sum1+" " +sum2);
            if(sum1>=sum2)
            {
                b[z]=sum1;
            }
            else
            {
                b[z]=sum2;
            }
            i++;
            z++;
        }while(lb1<ub1);
        int max=b[0];
        for(int j=0;j<b.length;j++)
        {
            if(max>b[j])
            {
                max=b[j];
            }
        }
        
        System.out.println("The answer is easy peasy"+max);

    }
}
