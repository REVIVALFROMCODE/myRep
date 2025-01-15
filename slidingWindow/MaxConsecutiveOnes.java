/*
        An intuitive puzzle: Find the length of the smallest subarray with a sum greater than or equal to s.
        ALGO:Move right pointer adding entry of right to Sum,
            once Sum greater than S, move left pointer to contract window

        Why calculate minLength inside while?
        Because only if Sum >= S, current length is valid result.
        Why calculate minLength before left++?
        Similar reason, after condition Sum >= S, length is valid, left++ pending on examine of condition.
        
     */
    public static int minSubArrayLen(int S, int[] nums) {
        int minLength = Integer.MAX_VALUE;
        int windowSum = 0;
        int left = 0;

        for (int right = 0; right < nums.length; right++) {
            windowSum += nums[right];

            while (windowSum >= S) {
                minLength = Math.min(minLength, right - left + 1);
                windowSum -= nums[left];
                left++;
            }
        }

        return minLength == Integer.MAX_VALUE ? 0 : minLength;
    }



/*
Input: nums = [0,0,1,1,0,0,1,1,1,0,1,1,0,0,0,1,1,1,1], k = 3
Output: 10
Explanation: [0,0,(1,1,1,1,1,1,1,1,1,1),0,0,0,1,1,1,1]
Bolded numbers were flipped from 0 to 1. The longest subarray is scoped.
*/
/*
GOAL:Find consecutive 1, we have number of k chance to flip 0 to 1.
ALGO:Increment R pointer, if encounter 0, increment zeroCount. When zero count reach K, we shrink pointer L (if previous entry L is 0, we decrement zeroCount).

*/
class Solution {
    public int longestOnes(int[] nums, int k) {
        int left = 0;
        int right = 0;
        int maxLen = 0;
        int zerosCount = 0;

        while (right < nums.length) {
            if (nums[right] == 0) {
                zerosCount++;
            }

            while (zerosCount > k) {
                if (nums[left] == 0) {
                    zerosCount--;
                }
                left++;
            }

            maxLen = Math.max(maxLen, right - left + 1);
            right++;
        }

        return maxLen;
    }
}
