/*
Input: arr = [1,2,2,1,1,3]
Output: true
Explanation: The value 1 has 3 occurrences, 2 has 2 and 3 has 1. No two values have the same number of occurrences.
*/
class Solution {
    public boolean uniqueOccurrences(int[] arr) {
        Map<Integer,Integer> map  = new HashMap<Integer,Integer>();

        for(int i=0;i<arr.length;i++){
            map.put(arr[i],map.getOrDefault(arr[i],0)+1);
        }
        Set<Integer> set = new HashSet<Integer>();
        Iterable<Integer> vals = map.values();
        for(int v:vals){
            if(set.contains(v)) return false;
            set.add(v);
        }
        return true;
    }
}
