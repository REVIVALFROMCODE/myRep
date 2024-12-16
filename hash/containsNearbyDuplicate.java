class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        /*
         * Input: nums = [1,2,3,1,2,3], k = 2
         * Output: false
         * nums[0]=nums[3], but 3-0>2
         * nums[1]=nums[4], but 4-1>2
         * nums[2]=nums[5], but 5-2>2
         * return false
         */
        // HashMap : nums[0] -> indice0

        HashMap<Integer, Integer> m = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (m.containsKey(nums[i])) {
                int res = i - m.get(nums[i]);
                if (res <= k) {
                    return true;
                } else {
                    m.put(nums[i], i);
                }
            } else {
                m.put(nums[i], i);
            }
        }
        return false;
    }
}
