/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        HashSet<ListNode> nodeList = new HashSet<>();
        while(headA != null) {
            nodeList.add(headA);
            headA = headA.next;
        }

        while(headB != null) {
            if(nodeList.contains(headB)) return headB;
            headB = headB.next;
        }
        return null;
    }
}