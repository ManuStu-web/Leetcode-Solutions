class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> answer = new ArrayList<>();
        List<Integer> ans = new ArrayList<>();

        helper(nums , 0 , answer , ans);
        return answer;
    }

    public void helper(int nums[] , int idx ,List<List<Integer>> answer , List<Integer> ans )
    {
        if(idx==nums.length)
        {
            if(!answer.contains(ans))
            {
                answer.add(new ArrayList<>(ans));
            }
            return;
        }

        for(int i=idx ; i<nums.length ; i++)
        {
            ans.add(nums[i]);
            helper(nums,i+1,answer,ans);

            ans.remove(ans.size()-1);
            helper(nums,i+1,answer,ans);
        }
    }
}
