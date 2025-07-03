/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode deleteDuplicates(ListNode head) 
    {
        if(head == null)
        {
            ListNode anshead = null;
            return anshead;
        }
        ListNode anstemp = new ListNode(head.val);
        ListNode anshead = anstemp;
        return recsolve(head, anstemp, anshead);
    }

    public ListNode recsolve(ListNode temp, ListNode anstemp , ListNode anshead)
    {
        if(temp==null)
        {
            return anshead;
        }

        if(anstemp.val!=temp.val)
        {
            ListNode node = new ListNode(temp.val);
            anstemp.next=node;
            node.next=null;
            anstemp=node;

            return recsolve(temp.next , anstemp, anshead);
        }

        return recsolve(temp.next, anstemp, anshead);

    }
}
