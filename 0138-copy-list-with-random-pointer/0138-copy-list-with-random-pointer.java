/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        Node copyHead = null;
        Node copyTail = null;
        Node temp = head;
        while(temp != null) {
            Node currNode = temp.next;
            Node nextNode = new Node(temp.val);
            nextNode.next = currNode;
            temp.next = nextNode;
            temp = currNode;
        }
        temp = head;
        while(temp != null) {
            Node copyNode = temp.next;
            if(temp.random != null) {
                copyNode.random = temp.random.next;
            }
            else {
                copyNode.random = null;
            }
            temp = temp.next.next;
        }
        temp = head;
        while(temp != null) {
            if(copyHead == null) {
                copyHead = temp.next;
                copyTail = temp.next;
            }
            else {
                copyTail.next = temp.next;
                copyTail = copyTail.next;
            }
            temp.next = temp.next.next;
            temp = temp.next;
        }
        return copyHead;
    }
}