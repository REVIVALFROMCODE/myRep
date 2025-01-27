/*
Two arrays cannot has intersection.
Input: nums1 = [1,2,3,3], nums2 = [1,1,2,2]
Output: [[3],[]]
Explanation:
For nums1, nums1[2] and nums1[3] are not present in nums2. Since nums1[2] == nums1[3], their value is only included once and answer[0] = [3].
Every integer in nums2 is present in nums1. Therefore, answer[1] = [].
*/
class Solution {
    public List<List<Integer>> findDifference(int[] nums1, int[] nums2) {
        HashSet<Integer> set1 =new HashSet<>();
        HashSet<Integer> set2 =new HashSet<>();
        HashSet<Integer> dup =new HashSet<>();
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        
        for(int i=0;i<nums1.length;i++)
        {
            set1.add(nums1[i]);
        }
        for(int i=0;i<nums2.length;i++)
        {
            if(set1.contains(nums2[i])){
                set1.remove(nums2[i]);
                dup.add(nums2[i]);
            }
            if(!dup.contains(nums2[i])){
                set2.add(nums2[i]);
            }
        }
        List<Integer> a1 = new ArrayList<Integer>(set1);
        List<Integer> a2 = new ArrayList<Integer>(set2);
        
        res.add(a1);
        res.add(a2);

        return res;
    }
}
