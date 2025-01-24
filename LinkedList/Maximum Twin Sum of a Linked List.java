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
