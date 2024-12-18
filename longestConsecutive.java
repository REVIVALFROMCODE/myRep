/*
Input: nums = [100,4,200,1,3,2]
Output: 4
Explanation: The longest consecutive elements sequence is [1, 2, 3, 4]. Therefore its length is 4.

For example, the sequence starting with 19 is: 19 → 82 → 68 → 100 → 1

If a number is unhappy, it enters a small cycle like: 4 → 16 → 37 → 58 → 89 → 145 → 42 → 20 → 4
*/
class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for(int n: nums){
            set.add(n);
        }
        int max=0;
        for(int n:set){
            if(!set.contains(n-1)){//finding possible start point of consecutive sequence
                int currentN = n;
                int currentLen = 1;
                while(set.contains(currentN+1)){
                    currentN+=1;
                    currentLen+=1;
                }
                max = currentLen>max? currentLen:max;
            }
        }
        return max;
    }
}
