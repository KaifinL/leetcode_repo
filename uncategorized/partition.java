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
    public ListNode partition(ListNode head, int x) {
        // both smaller and greater are portable.
        ListNode smaller = new ListNode(0);
        ListNode result = smaller;
        ListNode greater = new ListNode(0);
        ListNode second = greater;

        while (head != null) {
            if (head.val < x) {
                smaller.next = head;
                smaller = head;
            } else {
                greater.next = head;
                greater = head;
            }
            head = head.next;
        }
        
        greater.next = null;

        smaller.next = second.next;
        return result.next;
    }
}