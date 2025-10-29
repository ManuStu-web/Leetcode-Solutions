class Solution {
    public boolean isPalindrome(String s) 
    {
        StringBuilder str = new StringBuilder();
        for(int i=0;i<s.length();i++)
        {
          if(Character.isLetterOrDigit(s.charAt(i)))
          {
            str.append(Character.toLowerCase(s.charAt(i)));
          }
        }

        int l=0;
        int r=str.length()-1;

        while(l<=r)
        {
            if(str.charAt(l)!=str.charAt(r))
            {
                return false;
            }
            l++;
            r--;
        }

        return true;
    }
}
