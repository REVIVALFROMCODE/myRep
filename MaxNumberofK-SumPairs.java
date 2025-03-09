/*
Input: nums = [1,2,3,4], k = 5
Output: 2
Explanation: Starting with nums = [1,2,3,4]:
- Remove numbers 1 and 4, then nums = [2,3]
- Remove numbers 2 and 3, then nums = []
There are no more pairs that sum up to 5, hence a total of 2 operations.

Input: nums = [3,1,3,4,3], k = 6
Output: 1
Explanation: Starting with nums = [3,1,3,4,3]:
- Remove the first two 3's, then nums = [1,4,3]
There are no more pairs that sum up to 6, hence a total of 1 operation.
 
*/

import java.util.Arrays;

/*
GOAL: Find the number of all pairs of Integers that sum up to k in Array nums.
ALGO: Sort the array, then we are able to faciliate(Or you can say we convert new issue to well-known one) algorithm with two pointers pattern(sum<k i++, sum>k j--, else return(i,j)). 
Inorder to count the number, we replace return with ``cnt++``.

Analyze loop pattern:
1.Invariant condition: Before,Inside,After loop, invariant condition is always true: number of paris equal ``cnt`` in set [0,i] and [j,len-1].
2.Loop condition: i<j
After the loop, invariant condition still true but loop condition is false. As a result, loop condition protect that no intersection with above scope...
Assume that loop condition is i<=j, inside loop: we cannot exclude when i==j if ``nums[i]+nums[j] == k``, then cnt has wrong result which disobey invariant condition... Disproof loop condition i<j is correct.
*/
class Solution {
    public int maxOperations(int[] nums, int k) {
        Arrays.sort(nums);

        int cnt=0;
        int i=0, j=nums.length-1;

        while(i<j){
            if(nums[i]+nums[j]<k) {
                i++;
                continue;
            }
            else if(nums[i]+nums[j]>k) {
                j--;
                continue;
            }
            else{
                cnt++;
                i++;
                j--;
            }
        }
        return cnt;
    }
}

/*
Solution II: HashMap takes time propostional to N, but it actually takes 41 ms than sort algorithm which takes 19ms.
Because two pointers approach leads to better cache locality and fewer cache misses which can significantly speed up operation.
And HashMap involves overhead of space usage and additional hashing, collisions, dynamic resizing etc of constant factors. Especially it doesn't use cache wisely.
*/
class Solution {
    public int maxOperations(int[] nums, int k) {
        Map<Integer, Integer> countMap = new HashMap<>();
        int res = 0;
        for (int num : nums) {
            int complement = k - num;
            if (countMap.getOrDefault(complement, 0) > 0) {
                res++;
                countMap.put(complement, countMap.get(complement) - 1);
            } else {
                countMap.put(num, countMap.getOrDefault(num, 0) + 1);
            }
        }
        return res;
    }
}
