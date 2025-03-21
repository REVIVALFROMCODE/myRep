/*
        An intuitive puzzle: Find the length of the smallest subarray with a sum greater than or equal to s.
        ALGO:Move right pointer adding entry of right to Sum,
            once Sum greater than S, move left pointer to contract window

        Why calculate minLength inside while?
        Because only if Sum >= S, current length is valid result.
        Why calculate minLength before left++?
        Similar reason, after condition Sum >= S, length is valid, left++ pending on examine of condition.
        
     */

/*
 * precondition: 0<min<=len, 0<=l<=r<=len-1, winsum<S
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
        /*
         * preservation: winsum<S
         */
    }
    /*
     * postcondition: winsum<S
     * 
     * We are looking for minimum substring which sum >= S,
     * to make loop works -> we need to guarantee that winsum<S before, during and
     * after loop...
     */
    return minLength == Integer.MAX_VALUE ? 0 : minLength;

}

/*
 * Input: nums = [0,0,1,1,0,0,1,1,1,0,1,1,0,0,0,1,1,1,1], k = 3
 * Output: 10
 * Explanation: [0,0,(1,1,1,1,1,1,1,1,1,1),0,0,0,1,1,1,1]
 * Bolded numbers were flipped from 0 to 1. The longest subarray is scoped.
 */
/*
 * GOAL:Find consecutive 1, we have number of k chance to flip 0 to 1.
 * ALGO:Increment R pointer, if encounter 0, increment zeroCount. When zero
 * count reach K, we shrink pointer L (if previous entry L is 0, we decrement
 * zeroCount).
 * Why k=2, 1,1,1,0,0,0,1 works as expected?
 * 
 */

/**
 * precondition: 0count<=k
 */
class Solution {
    public int longestOnes(int[] nums, int k) {
        int left = 0, right = 0;
        int count = 0;
        int res = -1;
        for (right = 0; right < nums.length; right++) {
            if (nums[right] == 0)
                count++;
            while (count > k) {
                if (nums[left++] == 0)
                    count--;
            }
            /*
             * preservation: 0count<=k, then we easily deduce while(count>k)
             */
            res = Math.max(res, right - left + 1);
        }
        /*
         * postcondition: 0count<=k
         */
        return res;
    }
}
