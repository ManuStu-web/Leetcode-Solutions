class Solution {
    public String processStr(String s) 
    {
        String result="";
        for(int i=0;i<s.length();i++)
            {
                char f=s.charAt(i);
                if(Character.isLetter(f))
                {
                    result=result+f;
                }

                if(f=='#')
                {
                    result=result+result;
                }

                if(f=='*')
                {
                    String oldres = result;
                    result="";
                    int size=oldres.length();
                    for(int k=0;k<size-1;k++)
                        {
                            char ch=oldres.charAt(k);
                            result+=ch;
                        }
                }

                if(f=='%')
                {
                    String oldres = result;
                    result="";
                    int size=oldres.length();
                    for(int k=0;k<size;k++)
                        {
                            char ch=oldres.charAt(k);
                            result=ch+result;
                        }
                }
            }
        return result;
    }
}
