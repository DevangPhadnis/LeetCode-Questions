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
    public ListNode swapPairs(ListNode head) {

        if(head == null || head.next == null) return head;

        ListNode dummy = head;
        ListNode current = head.next;
        ListNode prev = new ListNode(-1);
        prev.next = head;
        ListNode beforeHead = prev;

        while(current != null) {
            ListNode temp = current.next;
            dummy.next = temp;
            current.next = dummy;
            prev.next = current;
            prev = dummy;
            if(temp != null) {
                current = temp.next; 
            }
            else {
                break;
            }
            dummy = dummy.next;
        }

        return beforeHead.next;
    }
}