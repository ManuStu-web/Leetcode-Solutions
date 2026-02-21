class Solution {
    public String longestCommonPrefix(String[] strs) 
    {
        String str=strs[0];
        String result="";
        if(strs.length==1)
        {
            return strs[0];
        }
        for(int i=1;i<strs.length;i++)
        {
            String currStr = strs[i];
            int j=0;
            while(j<(Math.min(currStr.length(),str.length()))&& currStr.charAt(j)==str.charAt(j))
            {
              j++;
            }
            result=str.substring(0,j);
            str=result;
        }

        return result;
    }
}
