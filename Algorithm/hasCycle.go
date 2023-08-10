/**
 * Definition for singly-linked list.
 * type ListNode struct {
 *     Val int
 *     Next *ListNode
 * }
 */
func hasCycle(head *ListNode) bool {
    var dummyHead=(*ListNode)(&ListNode{0,head})
    fast,slow:=head,dummyHead
    for fast!=nil&&slow!=nil&&fast.Next!=nil{
        if slow==fast{
            return true
        }
        slow=slow.Next
        fast=fast.Next.Next
    }
    return false
}
/*
func hasCycle(head *ListNode) bool {
    var m =map[*ListNode]bool{}
    for head!=nil{
        if _,ok:=m[head];ok{
            return true
        }else{
            m[head]=true
            head=head.Next
        }
    }
    return false
}
*/
