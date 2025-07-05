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
    public ListNode sortList(ListNode head) 
    {
         if(head==null || head.next==null)
        {
            return head;
        }
        ListNode mid = getMid(head);
        ListNode righthead = mid.next;
        mid.next = null;

        ListNode Left = sortList(head);
        ListNode Right = sortList(righthead);

        return mergesorter(Left,Right);

    }

    public static ListNode mergesorter(ListNode left , ListNode right)
    {
       ListNode answer = new ListNode(-1);
       ListNode tail=answer;

       while(left!=null && right !=null)
       {
        if(left.val<=right.val)
        {
           tail.next=left;
           left=left.next;
        }
        else
        {
            tail.next=right;
            right=right.next;
        }

        tail=tail.next;
       }

       if(left==null && right!=null)
       {
         tail.next=right;
       }
       else
       {
        tail.next=left;
       }

       return answer.next;
    }

    public static ListNode getMid(ListNode head)
    {
        ListNode s=head;
        ListNode f=head;

        while(f!=null && f.next!=null)
        {
           if(f.next.next==null)
           {
            return s;
           }
           s=s.next;
           f=f.next.next;
        }

        return s;
    }
}
