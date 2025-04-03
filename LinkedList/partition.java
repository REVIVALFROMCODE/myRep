/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode() {}
 * ListNode(int val) { this.val = val; }
 * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 #86: Partition List
 */
class Solution {
    public ListNode partition(ListNode head, int x) {
        //1.New two dummy and current
        ListNode lessHead = new ListNode(), greatHead = new ListNode(), lessCur = lessHead, greatCur = greatHead;
        
        //2.Itearate LinkedList and seperate 
        for(ListNode cur=head; cur!=null ; cur=cur.next){
            if(cur.val<x){
                lessCur.next=cur;
                lessCur = lessCur.next;
            }else{
                greatCur.next= cur;
                greatCur=greatCur.next;
            }
        }
        
        //3.Merge
        lessCur.next=greatHead.next;
        greatCur.next=null;//do not forget.

        return lessHead.next;
    }
}
