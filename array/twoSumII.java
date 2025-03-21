//167. Two Sum II - Input Array Is Sorted, use nlg2n time complexity
class Solution {
    public int[] twoSum(int[] numbers, int target) {
        for(int i=0; i<numbers.length; i++){
            int res = binarySearch(numbers, i+1, numbers.length-1, target-numbers[i]);
            if(numbers[i]+numbers[res]== target) return new int[]{i+1,res+1};
        }
        return null;
    }

    public int binarySearch(int[] numbers, int lo, int hi, int target){
        if(lo>=numbers.length) return lo;
        int mid = hi;
        while(lo<=hi){
            mid = (lo+hi)/2;
            if(target<numbers[mid]) hi=mid-1;
            else if (target>numbers[mid]) lo=mid+1;
            else return mid;
        }
        return mid;s
    }
}

//Solution 2, two pointers, use O(n) time complexity
class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int l = 0;
        int r = numbers.length-1;

        while(l<r){
            int sum = numbers[l]+numbers[r];
            if(target>sum) l++;
            else if (target<sum) r--;
            else return new int[]{++l,++r};
        }
        return null;
    }
}
