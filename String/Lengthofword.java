class Solution {
    public int lengthOfLastWord(String s) 
    {
        boolean ws =false,we=false;
        int count=0;
        for(int i=s.length()-1;i>=0;i--)
        {
            char ch = s.charAt(i);
           if(ch != ' ' && we==false)
           {
             ws=true;
             count++;
           }

           if(ch==' ' && ws==true)
           {
            break;
           }
        }

        return count;
    }
}
