/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode detectCycle(ListNode head) 
    {
        if (head == null || head.next == null || head.next.next == null) {
            return null;
        }
        return check(head,head.next.next,head.next);
    }

    public static ListNode check(ListNode head,ListNode f,ListNode s)
    {
        if(f==null || f.next==null)
        {
            return null;
        }
        if(f==s)
        {
            s=head;
            while(s!=f)
            {
                s=s.next;
                f=f.next;
            }

            return s;
        }

        return check(head, f.next.next, s.next);
    }
}
