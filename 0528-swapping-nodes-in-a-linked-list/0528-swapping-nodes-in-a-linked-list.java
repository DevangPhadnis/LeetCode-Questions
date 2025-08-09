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
    public ListNode swapNodes(ListNode head, int k) {

        if(head == null || head.next == null) return head;

        /* ArrayList<Integer> nodesArray = new ArrayList<>();

        ListNode start = head;
        while(start != null) {
            nodesArray.add(start.val);
            start = start.next;
        }

        int temp = nodesArray.get(k-1);
        nodesArray.set(k-1, nodesArray.get(nodesArray.size() - k));
        nodesArray.set(nodesArray.size() - k, temp);
        start = head;
        int idx = 0;
        while(start != null) {
            start.val = nodesArray.get(idx);
            start = start.next;
            idx++;
        }

        return head; */

        ListNode start = head;
        int count = 1;
        ListNode kBegin = null;
        ListNode kEnd = null;
        while(start != null) {
            count++;
            start = start.next;
        }

        start = head;
        int pointer = 1;
        while(start != null) {
            if(pointer == k) kBegin = start;
            else if(pointer == count-k) kEnd = start;
            pointer++;
            start = start.next;
        }
        if(kBegin == null || kEnd == null) return head;
        int temp = kBegin.val;
        kBegin.val = kEnd.val;
        kEnd.val = temp;

        return head;
    }
}