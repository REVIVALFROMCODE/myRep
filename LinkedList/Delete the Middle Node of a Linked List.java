/*
Input: head = [1,3,4,7,1,2,6]
Output: [1,3,4,1,2,6]
*/
//Solution 1 : takes 1.5 times of linear time 1.Count length 2. Find middle node and delete it 
class Solution {
    public ListNode deleteMiddle(ListNode head) {
        int len = 0;
        ListNode cur = head;
        while (cur != null) {
            len++;
            cur = cur.next;
        }
        if(len==1) return null;
        ListNode prev = new ListNode(0, head);
        cur = head;
        for (int i = 0; i < len / 2; i++) {
            cur = cur.next;
            prev = prev.next;
        }

        prev.next = cur.next;

        return head;
    }
}

//Solution2: every time fast node move forward 2 steps, slow node takes one step either.
class Solution {
    public ListNode deleteMiddle(ListNode head) {
        int cnt = 0;
        ListNode slow = head;
        ListNode fast = head;
        
        ListNode prev = new ListNode(0, head);
        while(fast!=null){
            cnt++;
            fast=fast.next;
            if(cnt==2){
                prev=prev.next;
                slow=slow.next;
                cnt=0;
            }
        }

        prev.next = slow.next;
        //Two special cases here:
        // 2-> 1 return 2 (slow!=head return head) 
        // 1 return null  (slow==head return prev.next)
        return  slow ==head ? prev.next:head;
    }
}
