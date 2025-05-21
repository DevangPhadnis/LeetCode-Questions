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
        ListNode start = new ListNode(-101);
        start.next = list1;
        ListNode temp = list2;
        ListNode startAdd = start;
        while(temp != null && start.next != null) {
            ListNode next = temp.next;
            if(temp.val > start.val && temp.val <= start.next.val) {
                temp.next = start.next;
                start.next = temp;
                temp = next;
            }
            else {
                start = start.next;
            }
        }
        if(start.next == null && temp != null) {
            start.next = temp;
        }
        return startAdd.next;
    }
}