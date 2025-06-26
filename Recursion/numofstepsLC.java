//Leetcode 1342

public class numofstepsLC 
{
    public static void main(String[] args) 
    {
        int N=0;
        int count=0;
        System.out.println(numberOfSteps(N, count));
    }

    static int numberOfSteps(int N,int count)
    {
        if(N<1)
        return count;
        
        count++;

        if(N%2==0)
        return numberOfSteps(N/2,count);

        return numberOfSteps(N-1,count);
    }
}
