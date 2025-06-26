//Leetcode 287
public class findduplicate {
    public static void main(String[] args) 
    {
        int a[]={1,3,4,2,2};
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
        //After Sorting the dupliccate element will alsways lie at the last index
        System.out.println("The Duplicate number is: "+a[a.length-1] );
       
    }
}
