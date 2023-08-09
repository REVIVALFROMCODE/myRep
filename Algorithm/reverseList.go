func reverseList(head *ListNode) *ListNode {
    cur,prev:=head,(*ListNode)(nil)
    for cur!=nil{
        cur.Next,cur,prev=prev,cur.Next,cur
    }
    return prev
}
