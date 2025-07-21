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
    public List<String> binaryTreePaths(TreeNode root) 
    {
        List<String> result = new ArrayList<>();
        helper(root, result , "");
        return result;
    }

    public void helper(TreeNode node , List<String> result,String s)
    {
        if(node.left==null && node.right==null)
        {
            s+=""+node.val;
            result.add(s);
            return;
        }
        s+=node.val+"->";
        if(node.left!=null)
        {
            helper(node.left,result,s);
        }
        if(node.right!=null)
        {
            helper(node.right,result,s);
        }
    }
}
