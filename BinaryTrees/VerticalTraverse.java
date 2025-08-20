class Solution {
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        Map<Integer, List<Pair>> map = new TreeMap<>();
        Queue<Pair> queue = new LinkedList<>();

        queue.offer(new Pair(root, 0, 0)); // node, hd, row

        while (!queue.isEmpty()) {
            Pair current = queue.poll();
            TreeNode node = current.node;
            int hd = current.hd;
            int row = current.row;

            map.putIfAbsent(hd, new ArrayList<>());
            map.get(hd).add(current);

            if (node.left != null) {
                queue.offer(new Pair(node.left, hd - 1, row + 1));
            }
            if (node.right != null) {
                queue.offer(new Pair(node.right, hd + 1, row + 1));
            }
        }

        List<List<Integer>> result = new ArrayList<>();
        for (List<Pair> list : map.values()) {
            // Sort by row first, then value
            Collections.sort(list, (a, b) -> {
                if (a.row != b.row) return a.row - b.row;
                return a.node.val - b.node.val;
            });

            List<Integer> column = new ArrayList<>();
            for (Pair p : list) {
                column.add(p.node.val);
            }
            result.add(column);
        }

        return result;
    }

    static class Pair {
        TreeNode node;
        int hd;   // horizontal distance
        int row;  // depth level

        Pair(TreeNode node, int hd, int row) {
            this.node = node;
            this.hd = hd;
            this.row = row;
        }
    }
}
