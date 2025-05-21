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
    public ListNode rotateRight(ListNode head, int k) {
        if(head == null) return null;
        if(k == 0) return head;
        ListNode temp = head;
        int size = 1;
        while(temp.next != null) {
            temp = temp.next;
            size++;
        }
        k = k % size;
        temp.next = head;
        int end = size - k;
        while(end >0) {
            temp = temp.next;
            end--;
        }
            head = temp.next;
            temp.next = null;
        
        return head;
    }
}