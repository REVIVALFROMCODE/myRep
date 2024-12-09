/*
Input: nums = [2,2,1,1,1,2,2]
Output: 2
*/
class Solution {
    public int majorityElement(int[] nums) {
        int count=0, candidate=nums[0];
        for(int i=0;i<nums.length;i++){
            if(count==0) candidate=nums[i];
            if(nums[i]==candidate) count++; else count--;
        }
        return candidate;
    }
}

//Solution2
class Solution
{
    public int majorityElement(int[] nums)
    {
        // Step 1: Start the recursive function with the entire array
        return getMajorityElement(nums, 0, nums.length - 1);
    }

    public static int getMajorityElement(int[] arr, int si, int ei)
    {
        // Step 2: Base case - If the array has one element, return it as the majority
        if (si == ei)
        {
            return arr[si];
        }

        // Step 3: Find the midpoint of the current range
        int mid = si + (ei - si) / 2;

        // Step 4: Recursively find majority elements in the left and right halves
        int left = getMajorityElement(arr, si, mid);
        int right = getMajorityElement(arr, mid + 1, ei);

        // Step 5: If the majority elements in both halves are the same, return it
        if (left == right)
        {
            return left;
        }
        
        // Step 6: Count the frequency of the two candidates in the current range
        int leftCount = countInRange(arr, left, si, ei);
        int rightCount = countInRange(arr, right, si, ei);

        // Step 7: Return the element with the higher count
        return leftCount > rightCount ? left : right;
    }

    public static int countInRange(int[] arr, int num, int si, int ei)
    {
        // Step 8: Count occurrences of `num` in the range [si, ei]
        int count = 0;
        for (int i = si; i <= ei; i++)
        {
            if (arr[i] == num)
            {
                count++;
            }
        }
        
        return count;
    }
}


//HashMap
class Solution
{
    // Step 1: Recursive method to count element frequencies in the array
    public static void getMejority(int[] arr, int si, int ei, HashMap<Integer, Integer> map)
    {
        // Step 2: Base case - When the subarray has one element, update its count
        if (si >= ei)
        {
            map.put(arr[si], map.getOrDefault(arr[si], 0) + 1);
            return;
        }

        // Step 3: Find the middle index to divide the array into two halves
        int mid = si + (ei - si) / 2;

        // Step 4: Recursively count frequencies in the left and right halves
        getMejority(arr, si, mid, map); // Process left half
        getMejority(arr, mid + 1, ei, map); // Process right half
    }

    // Step 5: Method to find the majority element
    public int majorityElement(int[] nums)
    {
        // Step 6: Create a map to store frequencies of elements
        HashMap<Integer, Integer> map = new HashMap<>();
        
        // Step 7: Call the recursive function to fill the map with frequencies
        getMejority(nums, 0, nums.length - 1, map);
        
        // Step 8: Initialize variables to track the element with the maximum frequency
        int maxKey = -1;
        int maxFrequency = Integer.MIN_VALUE;

        // Step 9: Iterate through the map to find the element with the highest frequency
        for (Map.Entry<Integer, Integer> entry : map.entrySet())
        {
            if (entry.getValue() > maxFrequency)
            {
                maxFrequency = entry.getValue();
                maxKey = entry.getKey();
            }
        }

        // Step 10: If the highest frequency is more than half the array length, return that element
        if (maxFrequency > nums.length / 2)
        {
            return maxKey; // Majority element found
        }

        // Step 11: If no majority element exists, return -1
        return -1; // No majority element exists
    }
}
