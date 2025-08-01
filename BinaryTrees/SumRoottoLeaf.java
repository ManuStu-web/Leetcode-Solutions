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
    public int sumNumbers(TreeNode root) 
    {
        return helper(root,0);
    }

    public int helper(TreeNode node , int ans)
    {
         if(node==null)
         {
            return 0;
         }

         ans=ans*10+node.val;

         if(node.left==null && node.right==null)
         {
            return ans;
         }

         return helper(node.left ,ans) + helper(node.right,ans);
         

    }
}
