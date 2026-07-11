class Solution {
    class Pair
    {
        String first;
        int second;
        Pair(String f , int s)
        {
            first=f;
            second=s;
        }
    }
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
         Set<String> set = new HashSet<>(wordList);
        if(!set.contains(endWord))
        {
            return 0;
        }

        Queue<Pair> q = new LinkedList<>();
        q.offer(new Pair(beginWord,1));
        while(!q.isEmpty())
        {
            String word=q.peek().first;
            int steps = q.peek().second;
            q.poll();

            if(word.equals(endWord))
            {
                return steps;
            }

            for(int i=0;i<word.length();i++)
            {
                for(char ch='a';ch<='z';ch++)
                {
                    char[] wordCharArray = word.toCharArray();
                    wordCharArray[i]=ch;
                    String newWord = new String(wordCharArray);
                    if(set.contains(newWord))
                    {
                        set.remove(newWord);
                        q.offer(new Pair(newWord,steps+1));
                    }
                }
            }
        }

        return 0;
    }
}
