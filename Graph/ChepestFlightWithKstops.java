class Solution {
    class Pair {
        int stops;
        int node;
        int cost;

        Pair(int s, int n, int c) {
            stops = s;
            node = n;
            cost = c;
        }
    }

    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        ArrayList<ArrayList<Pair>> adj = new ArrayList<>();
        int m = flights[0].length;
        for(int i=0;i<n;i++)
        {
            adj.add(new ArrayList<>());
        }

        for(int[] f : flights) {
            adj.get(f[0]).add(new Pair(0, f[1], f[2]));
        }

        int dis[]=new int[n];
        Arrays.fill(dis,Integer.MAX_VALUE);
        dis[src]=0;
        Queue<Pair> q = new LinkedList<>();
        q.offer(new Pair(0,src,0));

        while(!q.isEmpty())
        {
            Pair p = q.poll();
            int node = p.node;
            int cost = p.cost;
            int stops = p.stops;

            if(stops>k)
            {
                continue;
            }

            for(Pair it : adj.get(node))
            {
                int edW = it.cost;
                int adjNode = it.node;

                if(edW+cost<dis[adjNode])
                {
                    q.offer(new Pair(stops+1,adjNode,edW+cost));
                    dis[adjNode]=edW+cost;
                }
            }
        }

        if(dis[dst]==Integer.MAX_VALUE)
        {
            return -1;
        }

        return dis[dst];
    }
}
