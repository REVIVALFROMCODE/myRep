/*
Input: nums = [3,2,2,3], val = 3
Output: 2, nums = [2,2,_,_]
*/
class Solution {
    public int removeElement(int[] nums, int val) {
        //j used to keep track of the position where the next non-val element should be placed.
        int j=0;
        for (int i=0;i<nums.length;i++){ //iterate over the array
            if (val!=nums[i]){//save non-target to entry j
                nums[j]=nums[i];
                j++;
            }else continue;
        }
        return j;
    }
}
