class Solution {
    class Pair {
        int dis;
        int row;
        int col;

        Pair(int d, int r, int c) {
            dis = d;
            row = r;
            col = c;
        }
    }

    public int minimumEffortPath(int[][] heights) {
        int n = heights.length;
        int m = heights[0].length;

        int vis[][] = new int[n][m];
        for (int i = 0; i < n; i++) {
            Arrays.fill(vis[i], Integer.MAX_VALUE);
        }
        vis[0][0] = 0;
        PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> a.dis - b.dis);
        pq.offer(new Pair(0, 0, 0));

        while (!pq.isEmpty()) {
            Pair p = pq.poll();
            int dis = p.dis;
            int row = p.row;
            int col = p.col;

            if (row == n - 1 && col == m - 1) {
                return dis;
            }

            // up
            if (row > 0) {
                int val = Math.max(dis, Math.abs(heights[row][col] - heights[row - 1][col]));
                if (val < vis[row - 1][col]) {
                    vis[row - 1][col] = val;
                    pq.offer(new Pair(val, row - 1, col));
                }
            }

            // down
            if (row < n - 1) {
                int val = Math.max(dis, Math.abs(heights[row][col] - heights[row + 1][col]));
                if (val < vis[row + 1][col]) {
                    vis[row + 1][col] = val;
                    pq.offer(new Pair(val, row + 1, col));
                }
            }

            // left
            if (col > 0) {
                int val = Math.max(dis, Math.abs(heights[row][col] - heights[row][col - 1]));
                if (val < vis[row][col - 1]) {
                    vis[row][col - 1] = val;
                    pq.offer(new Pair(val, row, col - 1));
                }
            }

            // right
            if (col < m - 1) {
                int val = Math.max(dis, Math.abs(heights[row][col] - heights[row][col + 1]));
                if (val < vis[row][col + 1]) {
                    vis[row][col + 1] = val;
                    pq.offer(new Pair(val, row, col + 1));
                }
            }
        }

        return -1;
    }
}
