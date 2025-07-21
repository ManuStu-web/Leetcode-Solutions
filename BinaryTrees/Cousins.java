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
    public boolean isCousins(TreeNode root, int x, int y) {
        if (root == null || root.val == x || root.val == y) {
            return false;
        }

        Queue<TreeNode> store = new LinkedList<>();
        store.offer(root);

        while (!store.isEmpty()) {
            int size = store.size();
            boolean xflag = false;
            boolean yflag = false;
            for (int i = 0; i < size; i++) {
                TreeNode node = store.poll();

                if ((node.left != null && node.right != null)) {
                    if ((node.left.val == x && node.right.val == y) || (node.left.val == y && node.right.val == x)) {
                        return false;
                    }
                }
                if (node.left != null) {
                    if (node.left.val == x)
                        xflag = true;

                    if (node.left.val == y)
                        yflag = true;

                    store.offer(node.left);
                }

                if (node.right != null) {
                    if (node.right.val == x)
                        xflag = true;

                    if (node.right.val == y)
                        yflag = true;

                    store.offer(node.right);
                }
            }

            if (xflag == true && yflag == true) {
                return true;
            }
        }

        return false;

    }
}
