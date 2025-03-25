class Solution {
    public boolean canJump(int[] nums) {
        int maxReach = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i > maxReach) {
                return false; // If the current index is beyond the maximum reachable index
            }
            maxReach = Math.max(maxReach, i + nums[i]);
        }
        return maxReach >= nums.length - 1;
    }
}

/*
Input: nums = [2,3,1,1,4]
Output: true
Explanation: Jump 1 step from index 0 to 1, then 3 steps to the last index.
*/



//II
/*
Intuition :
At any position ( i ), the maximum range we can reach is ( i + nums[i] ).
Using a greedy strategy, we try to jump as far as possible within our current range before incrementing the jump count.
Track the maximum range we can reach in the current jump window. When we exhaust this range, it means we must take another jump.
*/
class Solution {
    public int jump(int[] nums) {
        if (nums.length <= 1) return 0;
        int jumps = 0;
        int currentEnd = 0;
        int furthest = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            furthest = Math.max(furthest, i + nums[i]);
            //update currentEnd when you have traversed all the indices within its range,
            if (i == currentEnd) {
                jumps++;
                currentEnd = furthest;
                if (currentEnd >= nums.length - 1) break;
            }
        }
        return jumps;
    }
}
