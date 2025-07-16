/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        boolean reverse = true;
        List<List<Integer>> ans = new ArrayList<>();
        if (root == null) {
            return ans;
        }
        Deque<TreeNode> store = new LinkedList<>();

        store.offer(root);
        while (!store.isEmpty()) {
            int size = store.size();
            List<Integer> inans = new ArrayList<>();

            for (int i = 0; i < size; i++) {
                if (reverse) {
                    TreeNode node = store.pollFirst();
                    inans.add(node.val);

                    if (node.left != null)
                        store.addLast(node.left);
                    if (node.right != null)
                        store.addLast(node.right);
                } else {
                    TreeNode node = store.pollLast();
                    inans.add(node.val);

                    if (node.right != null)
                        store.addFirst(node.right);
                    if (node.left != null)
                        store.addFirst(node.left);
                }

            }
            reverse = !reverse;

            ans.add(inans);
        }

        return ans;
    }
}
