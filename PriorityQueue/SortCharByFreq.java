class Solution {
    public String frequencySort(String s) {
        Map<Character,Integer> map = new HashMap<>();

        for(int i=0;i<s.length();i++)
        {
            char ch = s.charAt(i);
            map.put(ch,map.getOrDefault(ch,0)+1);
        }                                        

        PriorityQueue<Character> maxHeap = new PriorityQueue<>((a,b)-> map.get(b)-map.get(a));

        for(Character key : map.keySet())
        {
            maxHeap.offer(key);
        }
        StringBuilder ans = new StringBuilder();
        while(!maxHeap.isEmpty())
        {
            char ch = maxHeap.poll();

            for(int i=0;i<map.get(ch);i++)
            {
                ans.append(ch);
            }
        }

        return ans.toString();
    }
}
