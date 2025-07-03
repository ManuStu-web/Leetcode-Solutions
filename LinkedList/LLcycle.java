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
    public boolean hasCycle(ListNode head) 
    {
        if(head==null || head.next==null)
        {
            return false;
        }
        return check(head,head.next.next,head.next);
    }

    public static boolean check(ListNode head,ListNode f,ListNode s)
    {
        if(f==null || f.next==null)
        {
            return false;
        }
        if(f==s)
        {
            return true;
        }

        return check(head, f.next.next, s.next);
    }

}
