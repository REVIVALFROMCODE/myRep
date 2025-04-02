/*
Given the head of a singly linked list, group all the nodes with odd indices together followed by the nodes with even indices, 
and return the reordered list.
The first node is considered odd, and the second node is even, and so on.

Note that the relative order inside both the even and odd groups should remain as it was in the input.

You must solve the problem in O(1) extra space complexity and O(n) time complexity.

 
Input: head = [2,1,3,5,6,4,7]
Output: [2,3,6,7,1,5,4]
Split even and odd to two groups node by node.
*/
class Solution {
    public ListNode oddEvenList(ListNode head) {
         
        if (head==null || head.next==null) return head;

        ListNode last = head;     //last node of odd group
        ListNode cur = last.next;    //next node of last odd node is an even node.
        ListNode odd = cur.next;  //next node of cur node is an odd node. Your goal is insert this node behind last node.
        while (cur!=null && cur.next!=null){
            odd = cur.next;
            /*
            what you only need to concern is the last odd node ,
            each round you put new odd behind last odd, then update last odd.
            even nodes will in place naturally
            
            for doing this, 1.protect odd.next by cur.next = cur.next.next, 
            2.prev is referenced by cur

            maintain structure last->cur->odd, after insert odd between last and cur: last->odd->cur
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
//it is not actually swapping two nodes... but insert odd (cur.next) after last;
