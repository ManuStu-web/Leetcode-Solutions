class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer,Integer> map = new HashMap<>();
        for(int i=0;i<nums.length;i++)
        {
            if(map.containsKey(nums[i]))
            {
                map.put(nums[i],map.get(nums[i])+1);
            }
            else
            {
                map.put(nums[i],1);
            }
        }

        PriorityQueue<Integer> minHeap = new PriorityQueue<>((a,b)-> map.get(a)-map.get(b));

        for(Integer key: map.keySet())
        {
            minHeap.offer(key);

            if(minHeap.size()>k)
            {
                minHeap.poll();
            }
        }

        int ans[] = new int[k];
        int idx=0;
        while(!minHeap.isEmpty())
        {
            ans[idx]=minHeap.poll();
            idx++;
        }

        return ans;
    }
}
