/*
// Definition for a Node.
class Node {
    public int val;
    public Node prev;
    public Node next;
    public Node child;
};
*/

class Solution {
    public Node flatten(Node head) {
        Node t = head;
        while (t != null) {
            if (t.child == null) {
                t = t.next;
            } else {
                Node tnext = t.next;
                Node clast = getLastNode(t.child);
                t.child.prev = t;
                t.next = t.child;
                t.child = null;
                if (tnext != null) {
                    clast.next = tnext;
                    tnext.prev = clast;
                }
            }
        }

        return head;
    }

    public Node getLastNode(Node head) {
        while (head.next != null) {
            head = head.next;
        }

        return head;
    }
}
