class Solution {
    public int[][] merge(int[][] intervals) {
        
        if(intervals.length <= 1)
         return intervals;

         Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));

         List<int[]> result = new ArrayList<>();
         int start = intervals[0][0];
         int end = intervals[0][1];

         for(int i=1;i<intervals.length;i++)
         {
            int currstart = intervals[i][0];
            int currend = intervals[i][1];

            if(currstart <=end)
            {
                end = Math.max(end,currend);
            }
            else
            {
                result.add(new int[]{start,end});
                start=currstart;
                end=currend;
            }
         }

         result.add(new int[]{start,end});

         return result.toArray(new int[result.size()][]);
    }
}
