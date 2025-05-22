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
    public void reorderList(ListNode head) {
        if(head == null || head.next == null) return;
        ListNode slow = head;
        ListNode fast = head;

        while(fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }

        ListNode k = reverse(slow.next);
        slow.next = null;
        ListNode newNode = k;
        ListNode temp = head;
        while(temp != null && newNode != null) {
            ListNode c1 = temp.next;
            ListNode c2 = newNode.next;

            temp.next = newNode;
            newNode.next = c1;

            temp = c1;
            newNode = c2;
        }
    }

    public ListNode reverse(ListNode slow) {
        ListNode prev = null;
        ListNode curr = slow;
        ListNode nextNode = null;

        while(curr != null) {
            nextNode = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nextNode;
        }
        return prev;
    }
}