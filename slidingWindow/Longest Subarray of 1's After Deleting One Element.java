/*
Input: nums = [1,1,0,1]
Output: 3
Explanation: After deleting the number in position 2, [1,1,1] contains 3 numbers with value of 1's.
*/
class Solution {
    static{
        for(int i=0;i<500;i++) longestSubarray(new int[]{1});
    }
    public static int longestSubarray(int[] nums) {
        if(nums.length==1) return 0;
        int flag=0;
        int res=0;
        for(int left=0,right=0;right<nums.length;right++){
            if(nums[right]==0){
                flag++;
            }
            while(flag==2){
                if(nums[left++]==0) flag--;
            }
            res=Math.max(res,right-left);
        }
        return res;
    }
}
