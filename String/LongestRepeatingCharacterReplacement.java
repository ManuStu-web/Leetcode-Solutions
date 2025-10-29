class Solution {
    public int characterReplacement(String s, int k) 
    {
        int l=0;
        int r=0;
        int count[] = new int[26];
        int maxfreq=0;
        int maxlen=0;

        while(r<s.length())
        {
            count[s.charAt(r)-'A']++;
            maxfreq=Math.max(maxfreq,count[s.charAt(r)-'A']);

            if((r-l+1)-maxfreq>k)
            {
                count[s.charAt(l)-'A']--;
                l=l+1;
            }

            if((r-l+1)-maxfreq<=k)
            {
                maxlen = Math.max(maxlen,r-l+1);
            }

            r++;
        }

        return maxlen;
    }
}
