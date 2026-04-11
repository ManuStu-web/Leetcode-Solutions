class Solution {
    public List<List<String>> partition(String s) 
    {
        List<List<String>> answer = new ArrayList<>();
        List<String> path = new ArrayList<>();

        helper(0,s,answer,path);
        return answer;
    }

    public void helper(int idx , String s,List<List<String>> answer,List<String> path)
    {
        if(idx==s.length())
        {
            answer.add(new ArrayList<>(path));
            return;
        }

        for(int i=idx;i<s.length();i++)
        {
            if(isPalindrome(s,idx,i))
            {
                path.add(s.substring(idx,i+1));
                helper(i+1,s,answer,path);
                path.remove(path.size()-1);
            }
        }
    }

    public boolean isPalindrome(String s,int start, int end)
    {
        while(start<=end)
        {
            if(s.charAt(start)!=s.charAt(end))
            {
                return false;
            }
            start++;
            end--;
        }
        return true;
    }
}
