import java.util.*;

class Solution {

    int[] dr = {-1, 0, 1, 0};
    int[] dc = {0, 1, 0, -1};

    public boolean isValid(int r, int c, int n) {
        return r >= 0 && r < n && c >= 0 && c < n;
    }

    public int largestIsland(int[][] grid) {

        int n = grid.length;
        DisjointSet ds = new DisjointSet(n * n);

        // Connect all existing islands
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {

                if (grid[i][j] == 0)
                    continue;

                for (int k = 0; k < 4; k++) {

                    int newr = i + dr[k];
                    int newc = j + dc[k];

                    if (isValid(newr, newc, n) && grid[newr][newc] == 1) {

                        int nodeNo = i * n + j;
                        int adjNodeNo = newr * n + newc;

                        ds.unionBySize(nodeNo, adjNodeNo);
                    }
                }
            }
        }

        int mx = 0;

        // Try converting every 0 into 1
        for (int row = 0; row < n; row++) {
            for (int col = 0; col < n; col++) {

                if (grid[row][col] == 1)
                    continue;

                HashSet<Integer> components = new HashSet<>();

                for (int k = 0; k < 4; k++) {

                    int newr = row + dr[k];
                    int newc = col + dc[k];

                    if (isValid(newr, newc, n) && grid[newr][newc] == 1) {
                        components.add(ds.findUPar(newr * n + newc));
                    }
                }

                int sizeTotal = 1;

                for (int parent : components) {
                    sizeTotal += ds.size.get(parent);
                }

                mx = Math.max(mx, sizeTotal);
            }
        }

        // Case when grid is already all 1s
        for (int cell = 0; cell < n * n; cell++) {
            mx = Math.max(mx, ds.size.get(ds.findUPar(cell)));
        }

        return mx;
    }
}

class DisjointSet {

    List<Integer> parent = new ArrayList<>();
    List<Integer> size = new ArrayList<>();

    public DisjointSet(int n) {

        for (int i = 0; i < n; i++) {
            parent.add(i);
            size.add(1);
        }
    }

    public int findUPar(int node) {

        if (node == parent.get(node))
            return node;

        int ulp = findUPar(parent.get(node));
        parent.set(node, ulp);

        return ulp;
    }

    public void unionBySize(int u, int v) {

        int pu = findUPar(u);
        int pv = findUPar(v);

        if (pu == pv)
            return;

        if (size.get(pu) < size.get(pv)) {

            parent.set(pu, pv);
            size.set(pv, size.get(pu) + size.get(pv));

        } else {

            parent.set(pv, pu);
            size.set(pu, size.get(pu) + size.get(pv));
        }
    }
}
