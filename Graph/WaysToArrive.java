import java.util.*;

class Solution {

    class Pair {
        int node;
        long dist;

        Pair(int node, long dist) {
            this.node = node;
            this.dist = dist;
        }
    }

    public int countPaths(int n, int[][] roads) {

        int MOD = 1000000007;

        ArrayList<ArrayList<Pair>> adj = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }

        for (int[] r : roads) {
            adj.get(r[0]).add(new Pair(r[1], r[2]));
            adj.get(r[1]).add(new Pair(r[0], r[2]));
        }

        PriorityQueue<Pair> pq =
                new PriorityQueue<>((a, b) -> Long.compare(a.dist, b.dist));

        long[] dis = new long[n];
        Arrays.fill(dis, Long.MAX_VALUE);

        int[] ways = new int[n];

        dis[0] = 0;
        ways[0] = 1;

        pq.offer(new Pair(0, 0));

        while (!pq.isEmpty()) {

            Pair p = pq.poll();

            int node = p.node;
            long dist = p.dist;

            // Ignore outdated entries
            if (dist > dis[node])
                continue;

            for (Pair it : adj.get(node)) {

                int adjNode = it.node;
                long edgeWt = it.dist;

                if (dist + edgeWt < dis[adjNode]) {

                    dis[adjNode] = dist + edgeWt;
                    ways[adjNode] = ways[node];

                    pq.offer(new Pair(adjNode, dis[adjNode]));
                }
                else if (dist + edgeWt == dis[adjNode]) {

                    ways[adjNode] = (ways[adjNode] + ways[node]) % MOD;
                }
            }
        }

        return ways[n - 1];
    }
}
