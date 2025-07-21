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
    public boolean isSameTree(TreeNode p, TreeNode q) 
    {
       return helper(p,q);
    }

    public boolean helper(TreeNode p , TreeNode q)
    {
        // if((p.left!=null && q.left==null)||(p.left==null && q.left!=null))
        // {
        //     return false;
        // }

        if((p!=null && q==null)||(p==null && q!=null))
        {
            return false;
        }

        if(p==null || q==null)
        {
            return true;
        }

        boolean left = helper(p.left , q.left);
        boolean right = helper(p.right,q.right);
        boolean check=false;
        if(p.val==q.val)
        {
            check = true;
        }

        return left&&right&&check;
    }
}
