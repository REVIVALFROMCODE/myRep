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
    public ListNode reverseBetween(ListNode head, int left, int right) {
        /*
         * to find the left one :
         * ListNode current=head;
         * for(int i =0; i < left-1; i++){
         * current=current.next;
         * }
         * But for reverse LinkedList, steps are put left.next to the first node before
         * left,
         * then move forward.
         * e.g.
         * 1,2,3,4,5 left=2,right=5,
         * put 3 behind 1,
         * 1,3,2,4,5
         * put 4 behind 1,
         * 1,4,3,2,5
         * put 5 behind 1.
         * 1,5,4,3,2
         * /*
         * To find the first node before left
         */
        ListNode dummy = new ListNode(0, head);
        if (head == null)
            return dummy.next;
        ListNode prev = dummy;
        for (int i = 0; i < left - 1; i++) {
            prev = prev.next;
        }
        ListNode start = prev.next;
        ListNode then  = start.next;
        for(int i=0; i< right-left; i++){
            /*
            put then to prev.next
            */
            start.next = then.next;//save next node
            then.next = prev.next;//save node after prev
            prev.next = then;//put it
            
            

            //pointer start already move forwarded by swap.
            then=start.next;
        }

        return dummy.next;
    }
}

/*
Copilot Explanation
You want to reverse the nodes between the left and right positions in the linked list, where 1 <= left <= right <= n (n being the length of the list).

Steps
Dummy Node: Create a dummy node to handle edge cases more easily, such as reversing from the head of the list.

Find the Left Node: Traverse the list to find the node just before the left position (prev).

Reverse the Sublist: Use a pointer (start) at the left position and another (then) to iterate through the sublist to perform the reversal by changing pointers.
*/
