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
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if(list1==null)
        {
            return list2;
        }
        if(list2==null)
        {
            return list1;
        }
        ListNode ansList = new ListNode(-1);
        ListNode temp1 = list1;
        ListNode temp2 = list2;
        return helper(list1, list2, ansList , ansList);
    }

     public static ListNode helper(ListNode temp1, ListNode temp2 , ListNode anstemp , ListNode anshead)
    {
       if(temp1==null && temp2==null)
       {
         return anshead.next;
       }

       if(temp1==null && temp2!=null)
       {
         while(temp2!=null)
         {
            ListNode node = new ListNode(temp2.val);
            anstemp.next=node;
            anstemp=node;
            temp2=temp2.next;
         }
         return anshead.next;
       }

       if(temp1!=null && temp2==null)
       {
         while(temp1!=null)
         {
            ListNode node = new ListNode(temp1.val);
            anstemp.next=node;
            anstemp=node;
            temp1=temp1.next;
         }
         return anshead.next;
       }

       if(temp1.val == temp2.val)
       {
         ListNode node1 = new ListNode(temp1.val);
         ListNode node2 = new ListNode(temp2.val);

         anstemp.next=node1;
         node1.next=node2;
         anstemp = node2;
         anstemp.next=null;

         return helper(temp1.next, temp2.next, anstemp, anshead);
       }

       if(temp1.val<temp2.val)
       {
        ListNode node = new ListNode(temp1.val);
        anstemp.next=node;
        anstemp=node;
         return helper(temp1.next, temp2, anstemp, anshead);
       }

        ListNode node = new ListNode(temp2.val);
        anstemp.next=node;
        anstemp=node;
        return helper(temp1, temp2.next, anstemp, anshead);
    }
}
