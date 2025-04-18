/*
Input: nums = [2,2,1,1,1,2,2]
Output: 2
The majority element is the element that appears more than ⌊n / 2⌋ times.
*/
class Solution {
    public int majorityElement(int[] nums) {
        int count = 0, candidate = nums[0];
        for (int i = 0; i < nums.length; i++) {
            if (count == 0)
                candidate = nums[i];
            if (nums[i] == candidate)
                count++;
            else
                count--;
        }
        return candidate;
    }
}

// Solution2
class Solution {
    public int majorityElement(int[] nums) {
        // Step 1: Start the recursive function with the entire array
        return getMajorityElement(nums, 0, nums.length - 1);
    }

    public static int getMajorityElement(int[] arr, int si, int ei) {
        // Step 2: Base case - If the array has one element, return it as the majority
        if (si == ei) {
            return arr[si];
        }

        // Step 3: Find the midpoint of the current range
        int mid = si + (ei - si) / 2;

        // Step 4: Recursively find majority elements in the left and right halves
        int left = getMajorityElement(arr, si, mid);
        int right = getMajorityElement(arr, mid + 1, ei);

        // Step 5: If the majority elements in both halves are the same, return it
        if (left == right) {
            return left;
        }

        // Step 6: Count the frequency of the two candidates in the current range
        int leftCount = countInRange(arr, left, si, ei);
        int rightCount = countInRange(arr, right, si, ei);

        // Step 7: Return the element with the higher count
        return leftCount > rightCount ? left : right;
    }

    public static int countInRange(int[] arr, int num, int si, int ei) {
        // Step 8: Count occurrences of `num` in the range [si, ei]
        int count = 0;
        for (int i = si; i <= ei; i++) {
            if (arr[i] == num) {
                count++;
            }
        }

        return count;
    }
}

// Solution 3 HashMap
class Solution {
    public int majorityElement(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        // iterate nums and populate frequency into map
        getMejority(nums, 0, nums.length - 1, map);

        int maxKey = -1;
        int maxFrequency = Integer.MIN_VALUE;

        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() > maxFrequency) {
                maxFrequency = entry.getValue();
                maxKey = entry.getKey();
            }
        }
        return maxKey;
    }

    public static void getMejority(int[] arr, int si, int ei, HashMap<Integer, Integer> map) {
        if (si == ei) {
            map.put(arr[si], map.getOrDefault(arr[si], 0) + 1);
            return;
        }

        int mid = si + (ei - si) / 2;

        getMejority(arr, si, mid, map);
        getMejority(arr, mid + 1, ei, map);
    }
}

// Solution 4 Simplest way to utilize hash map
class Solution {
    public int majorityElement(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        int majorityElement = nums[0];
        int maxCount = 0;

        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() > maxCount) {
                maxCount = entry.getValue();
                majorityElement = entry.getKey();
            }
        }

        return majorityElement;
    }
}
