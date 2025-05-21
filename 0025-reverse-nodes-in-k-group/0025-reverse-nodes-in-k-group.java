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
    public ListNode reverseKGroup(ListNode head, int k) {
        if(head == null) return null;

        ListNode dummy = new ListNode(0);
        dummy.next = head;

        ListNode curr = dummy, nextNode = dummy, previous = dummy;
        int count = 0;

        while(curr.next != null) {
            curr = curr.next;
            count++;
        }

        while(count >= k) { 
            curr = previous.next;
            nextNode = curr.next;
            for(int i=1;i<k;i++) {
                curr.next = nextNode.next;
                nextNode.next = previous.next;
                previous.next = nextNode;
                nextNode = curr.next;
            }
            previous = curr;
            count-=k;
        }

        return dummy.next;
    }
}