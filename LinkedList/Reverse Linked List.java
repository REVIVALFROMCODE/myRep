class Solution {
    public ListNode reverseList(ListNode head) {
        if(head==null) return head;
        ListNode dummy = new ListNode(0,head);
        ListNode cur = head.next;
        ListNode prev = head;
        while(cur!=null){
            prev.next = cur.next;
            cur.next = dummy.next;// cur.next = prev is wrong
            dummy.next  = cur;

            cur=prev.next;
        }
        
        return dummy.next;
    }
}
