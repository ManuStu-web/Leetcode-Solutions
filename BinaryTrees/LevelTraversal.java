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
    public List<List<Integer>> levelOrder(TreeNode root) 
    {
        List<List<Integer>> ans = new ArrayList<>();
        if(root==null)
        {
            return ans;
        }
        
        Queue<TreeNode> store = new LinkedList<>();

        store.offer(root);
        while(!store.isEmpty())
        {
            int size = store.size();
            List<Integer> inans = new ArrayList<>();

            for(int i =0;i<size;i++)
            {
                TreeNode node = store.poll();
                inans.add(node.val);
                if (node.left != null) 
                {
                    store.offer(node.left);
                }
                if (node.right != null) 
                {
                    store.offer(node.right);
                }
            }

            ans.add(inans);
        }

        return ans;
    }
}
