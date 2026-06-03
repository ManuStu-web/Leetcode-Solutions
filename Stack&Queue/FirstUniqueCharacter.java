class Solution {
    public int firstUniqChar(String s) {
        int ans=-1;
        HashMap<Character,Integer> map = new HashMap<>();
        Stack<Integer> stack = new Stack<>();
        int n = s.length();
        for(int i=n-1;i>=0;i--)
        {
            char ch = s.charAt(i);
            if(map.containsKey(ch))
            {
                map.put(ch,map.get(ch)+1);
            }
            else
            {
                stack.push(i);
                map.put(ch,1);
            }
        }

        while(!stack.isEmpty())
        {
            int idx = stack.pop();
            char ch = s.charAt(idx);
            if(map.containsKey(ch))
            {
                if(map.get(ch)==1)
                {
                    ans=idx;
                    break;
                }
            }
        }

        return ans;
    }
}
