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
    public void reorderList(ListNode head) 
    {
         ListNode midd = mid(head);
        ListNode first=head;
        ListNode second=rev(midd.next);
        midd.next=null;

        while(second!=null)
        {
            ListNode t1next=first.next;
            ListNode t2next=second.next;

            first.next=second;
            second.next=t1next;

            first=t1next;
            second=t2next;
        }
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

     public static ListNode mid(ListNode head)
    {
       ListNode f=head;
       ListNode s=head;

       while(f!=null && f.next!=null)
       {
         s=s.next;
         f=f.next.next;
       }

       return s;
    }
}
