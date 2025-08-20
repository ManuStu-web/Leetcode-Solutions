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
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) 
    {
        List<Integer> ans =new ArrayList<>();
        List<List<Integer>> answer=new ArrayList<>();
        hasPath(root,targetSum,ans,answer);
        return answer;
    }

    public void hasPath(TreeNode root, int sum,List<Integer> ans,List<List<Integer>> answer)
    {
        if(root==null)
        {
            return;
        }

        if(root.left==null && root.right==null)
        {
            ans.add(root.val);
            if(root.val==sum)
            {
                List<Integer> duplicate = new ArrayList<>();
                for(int i=0;i<ans.size();i++)
                {
                    duplicate.add(ans.get(i));
                }
                answer.add(duplicate);
            }
            ans.remove(ans.size()-1);
            return;
        }

        ans.add(root.val);
        hasPath(root.left,sum-root.val,ans,answer);
        hasPath(root.right,sum-root.val,ans,answer);
        ans.remove(ans.size()-1); //backtracking
    }
}
