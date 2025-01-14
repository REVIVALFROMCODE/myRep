/*
Input: nums = [1,12,-5,-6,50,3], k = 4
Output: 12.75000
Explanation: Maximum average is (12 - 5 - 6 + 50) / 4 = 51 / 4 = 12.75
*/
/*
GOAL:Find max average value with k elements consecutively in Array nums.
ALGO:Using sliding windows with fixed length k, max average is equivalent to find max sum.
*/
class Solution {
    public double findMaxAverage(int[] nums, int k) {
        int i=0;
        int j=k-1;
        int sum=0;
        
        for(int p=0;p<k;p++) sum+=nums[p];
        int max=sum;
        while(true){
            
            sum-=nums[i];
            i++;
            j++;
            if(j>=nums.length) break;
            sum+=nums[j];
            max=Math.max(max,sum);
        }
        return (double)max/k;
    }
}
