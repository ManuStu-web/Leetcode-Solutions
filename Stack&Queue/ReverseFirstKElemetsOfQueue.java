class Solution {
    public Queue<Integer> reverseFirstK(Queue<Integer> q, int k) {
        if(q==null || k<=0 || k>q.size())
        {
            return q;
        }
        // code here
        Stack<Integer> s1 = new Stack<>();
        Stack<Integer> s2 = new Stack<>();
        
        while(!q.isEmpty())
        {
            s1.push(q.poll());
        }
        
        int size = s1.size();
        int skip = size-k;
        
        while(skip>0)
        {
            s2.push(s1.pop());
            skip--;
        }
        
        while(!s1.isEmpty())
        {
            q.offer(s1.pop());
        }
        
        while(!s2.isEmpty())
        {
            q.offer(s2.pop());
        }
        
        return q;
    }
}
