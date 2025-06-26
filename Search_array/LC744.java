//Leetcode 744
import java.util.*;

public class LC744
{
    static char searching(char ch[], char target)
    {
      int lb=0;
      int ub=ch.length-1;
      char ans=' ';

      if(target>=ch[ub])
      {
        return ch[0];
      }

      while(lb<=ub)
      {
        int mid=lb+(ub-lb)/2;
        if(ch[mid]<=target)
        {
            lb=mid+1;
        }
        else
        {
            ub=mid-1;
        }
        if(ch[mid]<target && ch[mid+1]>target)
        {
            ans=ch[mid+1];
        }
      }

      return ans;
    }


    public static void main(String args)
    {
        Scanner in = new Scanner(System.in);

        char ch[]={'c','f','j'};
        char target='a';

        searching(ch,target);
    }
}