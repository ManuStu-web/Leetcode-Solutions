class Solution {
    public int lengthOfLongestSubstring(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        int x = 0;
        int y = 0;
        int maxLen = 0;

        while (y < s.length()) {
            char ch = s.charAt(y);
            if (map.containsKey(ch)) 
            {
               x = Math.max(x,map.get(ch)+1);

            }


            map.put(ch, y);
            maxLen = Math.max(maxLen, (y - x + 1));

            y++;
        }

        return maxLen;
    }
}
