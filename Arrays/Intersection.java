import java.util.*;
class Solution {
    public int[] intersection(int[] nums1, int[] nums2) 
    {
        HashMap<Integer,Integer> map = new HashMap<>();

        for(int i=0;i<nums1.length;i++)
        {
            if(!map.containsKey(nums1[i]))
            {
                map.put(nums1[i],1);
            }
        }

        HashMap<Integer,Integer> ans = new HashMap<>();

        for(int i=0;i<nums2.length;i++)
        {
            if(map.containsKey(nums2[i]))
            {
                ans.put(nums2[i],1);
            }
        
        }

       int a[] = new int[ans.size()];
       int i=0;
       for(int key : ans.keySet())
       {
         a[i++]=key;
       }

       return a;
    }
}
