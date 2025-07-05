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
    public ListNode reverseList(ListNode head) 
    {
        if(head==null || head.next==null)
        {
            return head;
        }
        return rev(head);
    }

    public static ListNode rev(ListNode head)
    {
       ListNode prev = null;
       ListNode curr = head;
       ListNode nex;

       while(curr!=null)
       {
           nex=curr.next;
           curr.next=prev;
           prev=curr;
           curr=nex; 
       } 

       head=prev;
       return head;
    }
}
