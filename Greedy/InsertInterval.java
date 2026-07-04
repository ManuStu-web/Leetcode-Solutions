import java.util.*;

class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> ans = new ArrayList<>();
        int n = intervals.length;
        int i = 0;

        // Step 1: Add all intervals ending before newInterval starts
        while (i < n && intervals[i][1] < newInterval[0]) {
            ans.add(intervals[i]);
            i++;
        }

        // Step 2: Merge overlapping intervals
        while (i < n && intervals[i][0] <= newInterval[1]) {
            newInterval[0] = Math.min(newInterval[0], intervals[i][0]);
            newInterval[1] = Math.max(newInterval[1], intervals[i][1]);
            i++;
        }
        ans.add(newInterval);

        // Step 3: Add remaining intervals
        while (i < n) {
            ans.add(intervals[i]);
            i++;
        }

        // Convert List<int[]> to int[][]
        return ans.toArray(new int[ans.size()][]);
    }
}
