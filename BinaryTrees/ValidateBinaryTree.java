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
    public boolean isValidBST(TreeNode root) 
    {
        return helper(root,null,null);
    }

    public boolean helper(TreeNode root , Integer min , Integer max)
    {
        if(root==null)
        {
            return true;
        }

        if(min!=null && root.val<=min)
        {
            return false;
        }

        if(max!=null && root.val>=max)
        {
            return false;
        }

        boolean isleftValid = helper(root.left,min , root.val);
        boolean isrightValid = helper(root.right,root.val,max);
        
        return isleftValid && isrightValid;
    }
}
