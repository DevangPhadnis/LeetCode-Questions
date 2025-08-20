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
    public ListNode insertionSortList(ListNode head) {
        if(head == null || head.next == null) return head;

        ListNode temp = new ListNode(Integer.MIN_VALUE);
        temp.next = head;

        ListNode prevSorted = head;
        ListNode curr = head.next;

        while(curr != null) {
            if(curr.val >= prevSorted.val) {
                prevSorted = curr;
                curr = curr.next;
            }
            else {
                prevSorted.next = curr.next;

                ListNode start = temp;
                while(start.next.val <= curr.val) {
                    start = start.next;
                }

                curr.next = start.next;
                start.next = curr;

                curr = prevSorted.next;
            }
        }

        return temp.next;
    }
}