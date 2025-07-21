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
    public TreeNode buildTree(int []preorder , int[] inorder)
    {
        if(preorder.length==0)
        {
            return null;
        }

        int idxroot=0;
        for(int i=0;i<inorder.length;i++)
        {
           if(preorder[0]==inorder[i])
           {    
               idxroot=i;
               break;
           }
        }

        TreeNode root = new TreeNode(preorder[0]);

        root.left = buildTree(Arrays.copyOfRange(preorder,1,idxroot+1),Arrays.copyOfRange(inorder,0,idxroot));
        root.right= buildTree(Arrays.copyOfRange(preorder,idxroot+1,preorder.length), Arrays.copyOfRange(inorder,idxroot+1,inorder.length));

        return root;
    }
}
