class Solution {
    static ArrayList<Integer> nextSmallerEle(int[] arr) {
        // code here
        Stack<Integer> stack = new Stack<>();
        Stack<Integer> tempStack = new Stack<>();
        ArrayList<Integer> ans = new ArrayList<>();
        
        for(int i=arr.length-1;i>=0;i--)
        {
            while(!stack.isEmpty() && stack.peek() >= arr[i])
            {
                stack.pop();
            }
            
            if(stack.isEmpty())
            {
                ans.add(-1);
            }
            else
            {
                ans.add(stack.peek());
            }
            
            stack.push(arr[i]);
        }
        
        Collections.reverse(ans);
        return ans;
        
    }
}
