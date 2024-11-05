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
    public ListNode reverseBetween(ListNode head, int left, int right) {
       
        if(head==null) return null;

        ListNode dummy = new ListNode(0);
        dummy.next=head;
        ListNode prev=dummy;
         //find left one

         for(int i=0;i<left-1;i++){
            prev=prev.next;
         }

         ListNode start=prev.next, then = start.next;

         for(int i=0; i< right-left ; i++){
            //put then behind prev, prev.next is then, not swap start and then.
            // prev -> start -> then -> then.next
            // prev -> prev.next -> start -> then to prev->then->prev.next->start
            // 1,2,3,4 to 1,3,2,4 first round
            // 1,       3,          2,      4       to  1,  4,      3,  2
            // prev,    prev.next,  start,  then        
            start.next=then.next;
            then.next=prev.next; 
            prev.next=then;
            
            

            //update pointer for next iterate
            //prev -> then -> start ->start.next
             
            then=start.next;
         }

         return dummy.next;
    }
}
