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
    public List<List<Integer>> levelOrderBottom(TreeNode root) 
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
          List<Integer> level = new ArrayList<>();
          int size = store.size();
          for(int i=0;i<size;i++)
          {
             TreeNode node = store.poll();
             level.add(node.val);
             if(node.left!=null)
             {
                store.offer(node.left);
             }
             if(node.right!=null)
             {
              store.offer(node.right);
             }
          }

          ans.add(0,level); //Adding at the index 0 so it becomes reverse
        }

        return ans;
    }
}
