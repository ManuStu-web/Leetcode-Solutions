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
    public int countNodes(TreeNode root) {
        if(root==null)
        {
            return 0;
        }

        int left = getHeightLeft(root.left);
        int right = getHeightRight(root.right);

        if(left==right)
        {
            return ((2<<left)-1);
        }
        else
        {
            return 1+countNodes(root.left)+countNodes(root.right);
        }
    }

    private int getHeightLeft(TreeNode root)
    {
       int count = 0;
       while(root!=null)
       {
        count++;
        root=root.left;
       }

       return count;
    }

    private int getHeightRight(TreeNode root)
    {
       int count = 0;
       while(root!=null)
       {
        count++;
        root=root.right;
       }

       return count;
    }
}
