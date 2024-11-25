/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode() {}
 * ListNode(int val) { this.val = val; }
 * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        // Defensive code
        if (head == null)
            return null;
        ListNode dummy = new ListNode(0, head);
        ListNode cur = head;
        ListNode pre = dummy;
        while (cur != null) {// case [1,1]
            boolean isDup = false;
            // skip dup nodes
            while (cur.next != null && cur.val == cur.next.val) {
                isDup = true;
                cur = cur.next;
            }
            if (isDup)
                pre.next = cur.next;
            else
                pre = pre.next;

            cur = cur.next;
        }

        return dummy.next;
    }
}
