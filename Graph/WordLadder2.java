class Solution {
    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        Set<String> st = new HashSet<>(wordList);
        Queue<ArrayList<String>> q= new LinkedList<>();
        ArrayList<String> ls = new ArrayList<>();
        ls.add(beginWord);
        q.offer(ls);
        ArrayList<String> usedOnLevel = new ArrayList<>();
        List<List<String>> ans = new ArrayList<>();
        int level=0;
        while(!q.isEmpty())
        {
            ArrayList<String> vec = q.peek();
            q.poll();

            //check the level
            if(vec.size()>level)
            {
                level++;
                for(String it:usedOnLevel)
                {
                    st.remove(it);
                }
            }

            //get the latest word form the list we popped from queue
            String word = vec.get(vec.size()-1);
            if(word.equals(endWord))     //if the word == endword
            {
                if(ans.size()==0)   //check if it is first answer sequence
                {
                    ans.add(new ArrayList<>(vec));
                }
                else if(ans.get(0).size()==vec.size()) //if it is not first answer seqence so new answer sequece length should be equal to the first answer sequence
                {
                    ans.add(new ArrayList<>(vec));
                }
            }

            //try changing each letter
            for(int i=0;i<word.length();i++)
            {
                for(char ch='a';ch<='z';ch++)
                {
                    char replacedCharArray[] = word.toCharArray();
                    replacedCharArray[i]=ch;
                    String replacedWord = new String(replacedCharArray);
                    if(st.contains(replacedWord))
                    {
                        vec.add(replacedWord);
                        ArrayList<String> temp = new ArrayList<>(vec);
                        q.add(temp);
                        usedOnLevel.add(replacedWord);
                        vec.remove(vec.size()-1);
                    }
                }
            }
        
        }

        return ans;
    }
}
