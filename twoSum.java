class Solution {
    public int[] twoSum(int[] nums, int target) {
        //using hash table to find complement
        Map<Integer, Integer> map = new HashMap<>();
        for(int i=0; i<nums.length; i++){
            int com = target-nums[i];
            if (map.containsKey(com)){
                return new int[]{i, map.get(com)};
            }
            map.put(nums[i],i);
        }
        return null;
    }






    public int[] twoSum_v3(int[] nums, int target) {
        //sort -> binary search
        // well. if we sorted array, we lose index of original order...
        nums = insertion_sort(nums);
        for (int i=0;i<nums.length;i++){
            int com = target-nums[i];
            int res = binary_search(nums, com);
            if (res != -1 && res != i) return new int[]{i, res};
        }
        return null;
    }
    //1.sort
    int[] insertion_sort(int[] nums){
        for (int i = 0; i<nums.length; i++){
            for(int j=i-1;j>=0;j--){
                if (nums[j]>nums[i]){
                    int temp=nums[j]; nums[j]=nums[i]; nums[i]=temp;
                }
            }
        }
        return nums;
    }
    //2.binary search
    int binary_search(int[] nums, int target){
        int lo = 0;
        int hi = nums.length - 1;
        while (lo<=hi){
            int mid=(lo+hi)/2;
            if(nums[mid]>target){
                hi = mid-1;
            } else if (nums[mid]<target){
                lo = mid+1;
            } else{
                return mid;
            }
        }
        return -1;
    }

    




    public int[] twoSum_v2(int[] nums, int target) {
        //using hash table to find complement
        Map<Integer, Integer> map = new HashMap<>();
        for(int i=0; i<nums.length; i++){
            int com = target-nums[i];
            if (map.containsKey(com)){
                return new int[]{i, map.get(com)};
            }
            map.put(nums[i],i);
        }
        return null;
    }
    public int[] twoSum_v1(int[] nums, int target) {
        //iterate whole array - find complement: target-nums[i]
        for (int i=0;i<nums.length;i++){
            int find = target - nums[i];
            for (int j=i+1;j<nums.length;j++){
                if (nums[j]==find) return new int[]{i,j};
            }
        }
            return null;
    }
}
