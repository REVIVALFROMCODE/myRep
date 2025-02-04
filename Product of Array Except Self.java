/*
Given an integer array nums, return an array answer such that answer[i] is equal to the product of all the elements of nums except nums[i].
Input: nums = [1,2,3,4]
Output: [24,12,8,6]
*/

/*
Solution1:
each product  = left elments' product * right elements' product

1: 2*3*4 = ()*(2*3*4)
2: 1*3*4 = (1)*(3*4)
3：1*2*4 = (1*2)*(4)
4：1*2*3 = (1*2*3)*()

first round:
leftProduct *= nums[i++]
1
1*1
1*1*2
1*1*2*3

second round:
rightProduct *= nums[i--]
1
1*4
1*4*3
1*4*3*2
*/
public class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] result = new int[n];
        
        // Initialize the result array with 1s
        for (int i = 0; i < n; i++) {
            result[i] = 1;
        }
        
        // Calculate left products and store in result
        int leftProduct = 1;
        for (int i = 0; i < n; i++) {
            result[i] = leftProduct;
            leftProduct *= nums[i];
        }
        
        // Calculate right products and store in result
        int rightProduct = 1;
        for (int i = n - 1; i >= 0; i--) {
            result[i] *= rightProduct;
            rightProduct *= nums[i];
        }
        
        return result;
    }
}
