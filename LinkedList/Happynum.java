class Solution {
    public boolean isHappy(int n) 
    {
        return helprec(n);
    }
    public static boolean helprec(int digit)
    {
        int s=digit;
        int f =digit;

        do
        {
          s=findsquare(s);
          f=findsquare(findsquare(f));
        }while(s!=f);

        if(s==1 || f==1)
        {
         return true;
        }

        return false;
    }

    public static int findsquare(int n)
    {
        int sum=0;
        while(n>0)
        {
            int rem=n%10;
            sum+=rem*rem;
            n/=10;
        }

        return sum;
    }
}
