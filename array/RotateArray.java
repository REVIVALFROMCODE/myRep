class Solution {
    public void rotate(int[] nums, int k) {
        if(nums.length==1) return;// Handle single element case
        k = k % nums.length;// Normalize k
        k = nums.length - k;// Calculate the effective rotation
        //(Ar,Br)r = B,A
        rotate(nums,0,k);// Reverse the first k elements
        rotate(nums,k,nums.length);// Reverse the remaining elements
        rotate(nums,0,nums.length); // Reverse the entire array
    }
    private void rotate(int[] nums, int l, int r){
        r--;// Adjust r to be the last index
        while(l<r){
            int temp=nums[r]; 
            nums[r--]=nums[l]; 
            nums[l++]=temp;
        }
    }
}
