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
    public ListNode rotateRight(ListNode head, int k) {
        // Defensive code
        if (head == null)
            return null;
        // 1.Find tail Node
        ListNode tail = head;
        int N = 1;
        for (tail = head; tail.next != null; tail = tail.next) {
            N++;
        }
        // 2.Connect tail and head
        tail.next = head;// It used to be null.

        // 3.Find new tail and head
        int newTailPosition = N - k % N - 1;
        ListNode newTail = head;
        for (int i = 0; i < newTailPosition; i++) {
            newTail = newTail.next;
        }
        ListNode newHead = newTail.next;

        newTail.next = null;

        return newHead;
    }
}
