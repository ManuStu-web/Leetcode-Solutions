class Solution {
    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<int[]> maxHeap = new PriorityQueue<>((a,b)->{return ((b[0]*b[0])+(b[1]*b[1]))-((a[0]*a[0])+(a[1]*a[1]));});

        for(int[] i : points)
        {
            maxHeap.offer(i);

            if(maxHeap.size()>k)
            {
                maxHeap.poll();
            }
        }

        int ans[][] = new int[k][2];
        int idx=0;
        while(!maxHeap.isEmpty())
        {
            ans[idx]=maxHeap.poll();
            idx++;
        }

        return ans;

    }
}
