class Solution {
    Node root = new Node();
    public void insert(int num)
    {
        Node node = root;
        for(int i=31;i>=0;i--)
        {
            int bit = (num>>i)&1;
            if(!node.containsKey(bit))
            {
                node.put(bit,new Node());
            }

            node = node.get(bit);
        }
    }
    public int getMaxXor(int num)
    {
        Node node = root;
        int maxXOR=0;
        for(int i=31;i>=0;i--)
        {
            int bit = (num>>i)&1;
            if(node.containsKey(1-bit))
            {
                maxXOR |= (1<<i);
                node=node.get(1-bit);
            }
            else
            {
                node=node.get(bit);
            }
        }
        return maxXOR;
    }
    public int findMaximumXOR(int[] nums) {
        int ans=0;
        for(int num:nums)
        {
            insert(num);
        }

        for(int num:nums)
        {
            ans=Math.max(ans,getMaxXor(num));
        }

        return ans;
    }
}

class Node{
    Node links[] = new Node[2];
    public boolean containsKey(int bit)
    {
        return links[bit]!=null;
    }

    public void put(int bit, Node node)
    {
        links[bit]=node;
    }

    public Node get(int bit)
    {
        return links[bit];
    }
}
