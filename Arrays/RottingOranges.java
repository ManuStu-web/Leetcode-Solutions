class Neigh {
    int i, j;

    Neigh(int i, int j) {
        this.i = i;
        this.j = j;
    }
}

class Solution {
    public int orangesRotting(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;
        int fresh = 0;
        Queue<Neigh> queue = new LinkedList<>();

        // Step 1: Count fresh oranges and add rotten ones to the queue
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == 2) {
                    queue.add(new Neigh(i, j));
                } else if (grid[i][j] == 1) {
                    fresh++;
                }
            }
        }

        int time = 0;

        // Step 2: BFS traversal
        while (!queue.isEmpty() && fresh > 0) {
            int size = queue.size();

            for (int k = 0; k < size; k++) {
                Neigh current = queue.poll();
                int i = current.i;
                int j = current.j;

                // Check up
                if (i > 0 && grid[i - 1][j] == 1) {
                    grid[i - 1][j] = 2;
                    fresh--;
                    queue.add(new Neigh(i - 1, j));
                }

                // Check down
                if (i < rows - 1 && grid[i + 1][j] == 1) {
                    grid[i + 1][j] = 2;
                    fresh--;
                    queue.add(new Neigh(i + 1, j));
                }

                // Check left
                if (j > 0 && grid[i][j - 1] == 1) {
                    grid[i][j - 1] = 2;
                    fresh--;
                    queue.add(new Neigh(i, j - 1));
                }

                // Check right
                if (j < cols - 1 && grid[i][j + 1] == 1) {
                    grid[i][j + 1] = 2;
                    fresh--;
                    queue.add(new Neigh(i, j + 1));
                }
            }

            time++;
        }

        return fresh == 0 ? time : -1;
    }
}
