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
    public TreeNode invertTree(TreeNode root) 
    {
        return invertHelper(root);
    }

    public TreeNode invertHelper(TreeNode node)
    {
        if(node==null)
        {
            return node;
        }

        invertHelper(node.left);
        invertHelper(node.right);

        TreeNode temp = node.right;
        node.right=node.left;
        node.left=temp;

        return node;
    }
}
