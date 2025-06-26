//Leetcode 88

import java.util.Arrays;

public class mergesortleetcode 
{
    static void swap(int a[],int j)
    {
        int temp=a[j];
        a[j]=a[j-1];
        a[j-1]=temp;
    }
  public static void main(String[] args) 
  {
    int nums1[]={1,2,3,0,0,0};
    int nums2[]={2,5,6};
    int m=3;
    int n=3;

    int temp[]=new int[nums1.length];

    
    int i=0;
    for(i=0;i<m;i++)
    {
        if(nums1[i]!=0)
         temp[i]=nums1[i];
    }
    for(int j=0;j<n;j++)
    {
        temp[i]=nums2[j];
        i++;
    }

    for(int k=0;k<temp.length-1;k++)
    {
       for(int j=k+1;j>0;j--)
       {
         if(temp[j]<temp[j-1])
         {
            swap(temp,j);
         }
         else
         {
            break;
         }
       }
    }

    i=0;
    for(i=0;i<temp.length;i++)
    {
        nums1[i]=temp[i];
    }

    System.out.println(Arrays.toString(nums1));
  }   
}
