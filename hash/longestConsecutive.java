/*
Input: nums = [100,4,200,1,3,2]
Output: 4
Explanation: The longest consecutive elements sequence is [1, 2, 3, 4]. Therefore its length is 4.

GOAL: Find size of longest consecutive array in Array of integer.
ALGO: Put everything in HashSet, for each Integer, check does Integer minus one exist. IF:go ahead recursively, len++; ELSE:NONE.
DS:    Set<Integer>
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
