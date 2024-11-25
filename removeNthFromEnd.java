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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        // Defensive code
        if (head.next == null)
            return null;

        ListNode dummy = new ListNode(0, head);
        ListNode cur = dummy;
        for (int i = 0; i < n; i++) {
            cur = cur.next;
        }
        ListNode beforeDelete = dummy;

        // move forward until cur = tail
        while (cur.next != null) {
            cur = cur.next;
            beforeDelete = beforeDelete.next;
        }

        // delete beforeDelete.next
        beforeDelete.next = beforeDelete.next.next;

        return dummy.next;
    }
}
