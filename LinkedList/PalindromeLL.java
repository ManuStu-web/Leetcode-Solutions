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
    public boolean isPalindrome(ListNode head) 
    {
        return isspalindrom(head);
    }
    public static boolean isspalindrom(ListNode head)
    {

        ListNode mid = getMid(head);
        ListNode beforeMid = head;
        int count=1;

        // while(beforeMid.next!=mid)
        // {
        //     beforeMid=beforeMid.next;
        //     count++;
        // }

        ListNode nextphase= rev(mid.next);

        ListNode f=head;
        ListNode s=nextphase;
        

        while(s!=null)
        {
           if(f.val==s.val)
           {
            f=f.next;
            s=s.next;
           }
           else
           {
            return false;
           }
        }

        return true;
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
