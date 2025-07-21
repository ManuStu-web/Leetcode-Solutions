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
    public List<Double> averageOfLevels(TreeNode root) 
    {
        List<Double> ans = new ArrayList<>();
        if(root==null)
        {
            return ans;
        }
        Queue<TreeNode> store = new LinkedList<>();

        store.offer(root);
        while(!store.isEmpty())
        {
            int size = store.size();
            long sum=0;

            for(int i =0;i<size;i++)
            {
                TreeNode node = store.poll();
                sum+=node.val;
                if (node.left != null) 
                {
                    store.offer(node.left);
                }
                if (node.right != null) 
                {
                    store.offer(node.right);
                }
            }

            double value = (double)sum/size;

            ans.add(value);
        }

        return ans;
    }
}
