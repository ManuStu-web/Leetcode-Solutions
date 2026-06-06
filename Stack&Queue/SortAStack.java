class Solution {
    public void sortStack(Stack<Integer> st) {
        // code here
        if(!st.isEmpty())
        {
            int top = st.pop();
            
            sortStack(st);
            
            insertBack(st,top);
        }
    }
    
    private void insertBack(Stack<Integer> st , int top)
    {
        if(st.isEmpty() || st.peek()<=top)
        {
            st.push(top);
            return;
        }
        
        int x=st.pop();
        insertBack(st,top);
        
        st.push(x);
    }
}
