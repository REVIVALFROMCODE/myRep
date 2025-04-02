/*
Input: head = [1,2,3,4,5], n = 2
Output: [1,2,3,5]

we use pointer "cur" to track length of linked list

here is a trick:
trying to remove No.n node, move cur n steps from dummy, move cur until end of list, move newCur at the same time. 
When cur point to null, newCur point to the previous node we want to delete. 
Because compare with cur, newCur move less n steps. Just like newCur move backward from end of list.
*/
class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        // Defensive code
        if (head.next == null)
            return null;

        ListNode dummy = new ListNode(0, head);
        ListNode cur = head;
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
