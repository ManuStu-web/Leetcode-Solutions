import java.util.StringTokenizer;
class Solution {
    public String reverseWords(String s) 
    {
        StringTokenizer str = new StringTokenizer(s," ");
        StringBuilder newStr=new StringBuilder();

        while(str.hasMoreTokens())
        {
            newStr.insert(0,str.nextToken()+" ");
        }

        return newStr.toString().trim();

    }
}
