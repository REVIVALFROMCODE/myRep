import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/*
Solution brute force, following cannot avoid duplicate as expected.
Input: nums = [-1,0,1,2,-1,-4], Out:[[-1,0,1],[-1,2],[0,-1,1]]
Expected: [[-1,-1,2],[-1,0,1]]
*/
class threeSum {
    public List<List<Integer>> threeSum(int[] nums) {
        int N = nums.length;
        List<List<Integer>> res= new ArrayList<>();
        for (int i = 0; i < N; i++ )
            for (int j = i+1; j < N; j++ )
                for (int k = j+1; k < N; k++ ){
                    if (nums[i] + nums[j] + nums[k] == 0){
                        Set<Integer> set = new HashSet<>();
                        set.add(nums[i]);
                        set.add(nums[j]);
                        set.add(nums[k]);
                        //List<Integer> l = Arrays.asList(nums[i],nums[j],nums[k]);
                        List<Integer> l = new ArrayList<>(set);
                        res.add(l);
                    }
                }
        return res;
    }
}

/*
Available brute force, By using a Set of lists, we avoid adding duplicate triplets. Each triplet is *sorted* before adding to the set to ensure the order is consistent.
Set<List<Integer>> will consider [0,1,-1],[-1,0,1] as no dup/ But after sorting, will consider [-1,0,1] as dup.
*/
class threeSum2 {
    public List<List<Integer>> threeSum(int[] nums) {
        Set<List<Integer>> res = new HashSet<>(); // To avoid duplicates

        for (int i = 0; i < nums.length - 2; i++) {
            for (int j = i + 1; j < nums.length - 1; j++) {
                for (int k = j + 1; k < nums.length; k++) {
                    if (nums[i] + nums[j] + nums[k] == 0) {
                        List<Integer> triplet = java.util.Arrays.asList(nums[i],nums[j],nums[k]);
                        triplet.sort(null); // Ensure the triplet is in a consistent order
                        res.add(triplet);
                    }
                }
            }
        }

        return new ArrayList<>(res);
    }

}

/*
Thrid try brute force, self implement insertion sort. Still Time Limit Exceeded...
*/


class threeSum3 {
    public List<List<Integer>> threeSum(int[] nums) {
        Set<List<Integer>> res = new HashSet<>(); // To avoid duplicates
        for (int i = 0; i < nums.length - 2; i++) {
            for (int j = i + 1; j < nums.length - 1; j++) {
                for (int k = j + 1; k < nums.length; k++) {
                    if (nums[i] + nums[j] + nums[k] == 0) {
                        List<Integer> triplet = java.util.Arrays.asList(nums[i], nums[j], nums[k]);
                        insertionSort(triplet); // Ensure the triplet is in a consistent order
                        res.add(triplet);
                    }
                }
            }
        }
        return new ArrayList<>(res);
    }

    
//How to implement correct insertion sort of List at first time? Answer is we implement a known insertion sort of array.And convert array to List.
    public void insertionSort(List<Integer> a) {
        for (int i = 1; i < a.size(); i++) {
            while (i - 1 >= 0 && a.get(i-1)>a.get(i)) {
                Integer temp = a.get(i-1);
                a.set(i-1,a.get(i));
                a.set(i--,temp);
            }
        }
    }
    public void InsertionSort(int[] a) {
        for (int i = 0; i < a.length; i++) {
            for (int j = i; j > 0 && a[j]<a[j-1]; j--) {
                exch(a, j, j-1);
            }
        }
    }
    public void exch(int[] a, int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
}


//Solution 4: Two pointers 

class threeSum4 {
    public List<List<Integer>> threeSum(int[] nums) {
        java.util.Arrays.sort(nums);
        List<List<Integer>> ans = new ArrayList<>();
        int n = nums.length;
        for (int i = 0; i < n - 2; i++) {
            int x = nums[i];
            if (i > 0 && x == nums[i - 1]) continue; // 跳过重复数字
            if (x + nums[i + 1] + nums[i + 2] > 0) break; // 优化一
            if (x + nums[n - 2] + nums[n - 1] < 0) continue; // 优化二
            int j = i + 1;
            int k = n - 1;
            while (j < k) {
                int s = x + nums[j] + nums[k];
                if (s > 0) {
                    k--;
                } else if (s < 0) {
                    j++;
                } else { // 三数之和为 0
                    ans.add(List.of(x, nums[j], nums[k]));
                    for (j++; j < k && nums[j] == nums[j - 1]; j++); // 跳过重复数字
                    for (k--; k > j && nums[k] == nums[k + 1]; k--); // 跳过重复数字
                }
            }
        }
        return ans;
    }
}
/*
What Happens if You Remove Duplicates After Sorting
Loss of Valid Triplets:
Any triplet that depends on duplicate elements will no longer be found.
Input: nums = [-1, -1, 0, 1, 2]
After removing duplicates: nums = [-1, 0, 1, 2]
The valid triplet [-1, -1, 2] is lost.
*/
