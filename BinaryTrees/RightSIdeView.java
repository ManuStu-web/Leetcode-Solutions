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
     public List<Integer> rightSideView(TreeNode root) 
    {
        List<Integer> ans = new ArrayList<>();

        if(root==null)
        {
            return ans;
        }
        
        Queue<TreeNode> store = new LinkedList<>();  
        store.offer(root);
        ans.add(root.val);

        while(!store.isEmpty())
        {
            int size = store.size();

            for(int i=0;i<size;i++)
            {
                TreeNode node = store.poll();

                if(node.right!=null)
                {
                    store.offer(node.right);
                }
                if(node.left!=null)
                {
                    store.offer(node.left);
                }
            }

            if(store.peek()!=null)
            ans.add(store.peek().val);
        }

        return ans;
    }
}
