/*
Input: head = [4,2,2,3]
Output: 7
*/
/*
Solution1: Reverse linked list from middle, because you cannot traverse linked list backward as array(not a bidirectional list).
*/
class Solution {
    // Function to find the middle of the linked list
    private static ListNode findMiddle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    // Function to reverse the linked list
    private static ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode current = head;
        while (current != null) {
            ListNode nextNode = current.next;
            current.next = prev;
            prev = current;
            current = nextNode;
        }
        return prev;
    }

    // Function to find the maximum twin sum
    public static int pairSum(ListNode head) {
        if (head == null) {
            return 0;
        }

        // Step 1: Find the middle of the list
        ListNode mid = findMiddle(head);

        // Step 2: Reverse the second half of the list
        ListNode secondHalf = reverseList(mid);

        // Step 3: Compute the twin sums
        int maxSum = 0;
        ListNode firstHalf = head;
        while (secondHalf != null) {
            maxSum = Math.max(maxSum, firstHalf.val + secondHalf.val);
            firstHalf = firstHalf.next;
            secondHalf = secondHalf.next;
        }

        return maxSum;
    }
}

/*
 Optimal solution: 
 Reverse first half rather second half, that's avoid to find middle node.
*/
    public int pairSum(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        ListNode prev = null; //what you want is cut the half off, null(prev),1->2->3 to 3->2->1->null
        //Reverse the First Half
        while(fast!=null){
            fast = fast.next.next; // trace half
            ListNode tmp = slow.next; //store slow.next
            slow.next = prev; //when reversing list, prev is the next one of current slow
            prev = slow; //update prev as new next one
            slow = tmp; //new round
        }
        //As a result, list will be cut off. 4->2->2->3 to 2->4 and 2->3
        int max=0;
        while (slow!=null){
            int currvValue = slow.val + prev.val;
            if (currvValue>max){
                max = currvValue;
            }
            slow = slow.next;
            prev = prev.next;
        }
        return max;
    }
