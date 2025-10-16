class Solution {
    public int totalFruit(int[] fruits) {
        int l=0;
        int r=0;
        int maxLen=0;
        int k=2;
        HashMap<Integer,Integer> map = new HashMap<>();

        while(r<fruits.length)
        {
            if(map.containsKey(fruits[r]))
            {
                map.put(fruits[r],map.get(fruits[r])+1);
            }
            else
            {
                map.put(fruits[r],1);
            }
            while(map.size()>k)
            {
                map.put(fruits[l],map.get(fruits[l])-1);
                if(map.get(fruits[l])==0)
                {
                    map.remove(fruits[l]);
                }
                l++;
            }
            if(map.size()<=k)
            {
                maxLen=Math.max(maxLen,r-l+1);
            }
            r++;
        }
        return maxLen;
    }
}
