/*
Example 1:
Input: nums = [1,7,3,6,5,6]
Output: 3
Explanation:
The pivot index is 3.
Left sum = nums[0] + nums[1] + nums[2] = 1 + 7 + 3 = 11
Right sum = nums[4] + nums[5] = 5 + 6 = 11

Example 2:
Input: nums = [1,2,3]
Output: -1
Explanation:
There is no index that satisfies the conditions in the problem statement.

Example 3:
Input: nums = [2,1,-1]
Output: 0
Explanation:
The pivot index is 0.
Left sum = 0 (no elements to the left of index 0)
Right sum = nums[1] + nums[2] = 1 + -1 = 0
*/

//GOAL find pivot index which sumL equal sumR. 
//ALGO start from index zero, which sumL=0, sumR=sum-nums[0], note that edge cases is important. Increment L and decrement R.
class Solution {
    //O(N)
    public int pivotIndex(int[] nums) {
        int l=-1; int r=1;
        int suml=0; int sumr=0;

        for(int i=1;i<nums.length;i++) sumr+=nums[i];

        while(r<=nums.length){
            if(suml==sumr && r-l-1==1){
                return l+1;
            }
            if(r==nums.length) return -1;
            suml+=nums[++l];
            sumr-=nums[r++];
            
        }
        return -1;
    }
}




class Solution {
    public int pivotIndex(int[] nums) {
        if(nums.length==1) return 0;
        int l = 0;
        int r = 1;
        int suml = 0;
        int sumr = 0;
//precondition: l=0 r=1 suml=0; sumr=sum-nums[0];
        for (int i = 1; i < nums.length; i++)
            sumr += nums[i];
        while (r < nums.length) {
            if (suml == sumr)
                return l;
            suml += nums[l++];
            sumr -= nums[r++];
            if (suml == sumr)
                return l;
        }
        //postcondition: l=nums.length-1, r=nums.length
        return -1;
    }
}
