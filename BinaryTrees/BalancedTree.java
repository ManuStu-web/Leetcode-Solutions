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
    boolean result=true;
    public boolean isBalanced(TreeNode root) 
    {
        helper(root);
        return result;
    }

    public int helper(TreeNode node)
    {
        if(node==null)
        {
            return 0;
        }
        
        int isLeft = helper(node.left);
        int isRight=helper(node.right);

//Deciding line is only this , same as taking height of the tree
        result =result && Math.abs(isLeft-isRight) <=1;
     

        return Math.max(isLeft , isRight)+1;
    }

    
}
