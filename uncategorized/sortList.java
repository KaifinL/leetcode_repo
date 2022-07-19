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
    public ListNode sortList(ListNode head) {
        List<Integet> nodes_val = new ArrayList();
        ListNode curr = head;
        while (curr != null) {
            nodes_val.add(curr.val);
            curr = curr.next;
        }
        int vals = new int[nodes_val.size()]
        for (int i = 0; i < nodes_val.size(); i++) {
            vals[i] = nodes_val.get(i);
        }
        Arrays.sort(vals);
        curr = head;
        int index = 0;
        while (curr != null) {
            head.val = vals[index];
            index++;
            curr = curr.next;
        }
        return head;
    }
}