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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode head = null;
        ListNode tail = null;
        int carry = 0;
        while(l1 != null || l2 != null) {
            int sum = 0;
            if(l1 != null) {
                sum+= l1.val;
            }
            if(l2 != null) {
                sum+= l2.val;
            }
            sum+= carry;
            carry = sum / 10;
            ListNode temp = new ListNode(sum % 10);
            if(head == null) {
                head = temp;
                tail = temp;
            }
            else {
                tail.next = temp;
                tail = tail.next;
            }
            if(l1 != null) l1 = l1.next;
            if(l2 != null) l2 = l2.next;
        }
        while(carry > 0) {
            ListNode temp = new ListNode(carry % 10);
            carry = carry / 10;
            if(head == null) {
                head = temp;
                tail = temp;
            }
            else {
                tail.next = temp;
                tail = tail.next;
            }
        }
        return head;
    }
}