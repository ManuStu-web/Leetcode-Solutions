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
    public ListNode rotateRight(ListNode head, int k) 
    {
        if(head==null || head.next==null||k<=0)
        {
            return head;
        }
        
        ListNode temp=head;
        int length=1;

        while(temp.next!=null)
        {
            temp=temp.next;
            length++;
        }

        temp.next=head;
        int rot=k%length;
        int skip=length-rot;

        ListNode lasttemp = head;
        for(int i=0;i<skip-1;i++)
        {
            lasttemp=lasttemp.next;
        }

        head=lasttemp.next;
        lasttemp.next=null;
         return head;
    }
}
