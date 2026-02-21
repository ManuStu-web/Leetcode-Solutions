class Solution {
    public boolean checkInclusion(String s1, String s2) 
    {
        int arr[] = new int[26];

        for(int i=0;i<s1.length();i++)
        {
            arr[s1.charAt(i)-'a']++;
        }

        int l=0;
        int r=s1.length()-1;

        while(r<s2.length())
        {
            int arr2[] = new int[26];
            for(int i=l;i<=r;i++)
            {
                arr2[s2.charAt(i)-'a']++;
            }

            if(Arrays.equals(arr,arr2))
            {
                return true;
            }
            l++;
            r++;
        }

        return false;
    }
}
