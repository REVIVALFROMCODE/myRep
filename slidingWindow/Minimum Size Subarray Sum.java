/*
Input: target = 7, nums = [2,3,1,2,4,3]
Output: 2
Explanation: The subarray [4,3] has the minimal length under the problem constraint.
*/

//Solution1 Takes 2ms
class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int i=0,j=0,max=Integer.MAX_VALUE,sum=0;
        for(j=0;j<nums.length;j++){
            sum  += nums[j];
          
            while(j>i && sum - nums[i] >= target){
                sum -= nums[i++];
            }
            
            if(sum >= target && j-i+1<max) max=j-i+1;
        }
        return max==Integer.MAX_VALUE? 0:max;
    }
}

//Solution2 Takes 1ms
class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int i=0,j=0,max=Integer.MAX_VALUE,sum=0;
        for(j=0;j<nums.length;j++){
            sum  += nums[j];

            while(sum >= target){
                if(j-i+1<max) max=j-i+1;
                sum -= nums[i++];
            }

        }
        return max==Integer.MAX_VALUE? 0:max;
    }
}
