/*
Input: head = [2,1,3,5,6,4,7]
Output: [2,3,6,7,1,5,4]
*/
class Solution {
    public ListNode oddEvenList(ListNode head) {
         
        if (head==null || head.next==null) return head;

        ListNode last = head;     
        ListNode cur = last.next;    
        ListNode odd = cur.next;
        while (cur!=null && cur.next!=null){
            odd = cur.next;
            /*
            what you only need to concern is the last odd node ,
            each round you put new odd behind last odd, then update last odd.
            even nodes will in place naturally
            
            for doing this, 1.protect odd.next by cur.next = cur.next.next, 
            2.prev is referenced by cur
            */
            cur.next=cur.next.next;
            odd.next = last.next;
            last.next = odd;
            last=odd;

            cur=cur.next;
        }
        return head;
    }
}
