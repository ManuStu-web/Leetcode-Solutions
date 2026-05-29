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
    public ListNode reverseBetween(ListNode head, int left, int right) 
    {
        if(head==null || left==right)
        {
            return head;
        }

       ListNode prev=null;
       ListNode curr=head;

       for(int i=1;i<left;i++)
       {
         prev=curr;
         curr=curr.next;
       }

        ListNode leftPrev = prev;
        ListNode newEnd = curr; //end of reversed list node i.e 2

        ListNode next = null;
        ListNode revPrev = null;

       for(int i=left;i<=right;i++)
       {
         next=curr.next;
         curr.next=revPrev;
         revPrev=curr;
         curr=next;
       }

       //iss postion par curr point karega 5 node ko
       //revPrev point kargea 4 ko
       //next point karga null ko

       //connections theek karenge aab
      if(leftPrev!=null)
      {
        leftPrev.next=revPrev; //1->4
      }
      else
      {
        head=revPrev; //if left=1 de rakha hai , to 4 kardo head ( starting of listNode )
      }
        newEnd.next=curr; //2->5 kardo
        return head;

    }
}
