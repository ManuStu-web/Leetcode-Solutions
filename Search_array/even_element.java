//Leetcode 1295
//teling how many elemts is having even number of digits 

import java.util.*;
public class even_element 
{
    public static void main(String[] args) 
    {
        Scanner in = new Scanner(System.in);
        int arr[]={213,3234,2334,23,672,98};
        int count=0;
        for(int i=0;i<arr.length;i++)
        {
         int n= even(arr[i]);
         if(n%2==0)
         {
            count++;
         }
        }

        System.out.println("No. of even elemets are:"+count);
    }

    static int even(int ele)
    {
      int count=0;
      while(ele>0)
      {
        count++;
        ele/=10;
      }
      return count;
    }
}
