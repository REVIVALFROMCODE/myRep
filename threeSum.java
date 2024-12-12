/*
Solution brute force, following cannot avoid duplicate as expected.
Input: nums = [-1,0,1,2,-1,-4], Out:[[-1,0,1],[-1,2],[0,-1,1]]
Expected: [[-1,-1,2],[-1,0,1]]
*/
class Solution {
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
public class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Set<List<Integer>> res = new HashSet<>(); // To avoid duplicates

        for (int i = 0; i < nums.length - 2; i++) {
            for (int j = i + 1; j < nums.length - 1; j++) {
                for (int k = j + 1; k < nums.length; k++) {
                    if (nums[i] + nums[j] + nums[k] == 0) {
                        List<Integer> triplet = Arrays.asList(nums[i],nums[j],nums[k]);
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


public class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Set<List<Integer>> res = new HashSet<>(); // To avoid duplicates
        for (int i = 0; i < nums.length - 2; i++) {
            for (int j = i + 1; j < nums.length - 1; j++) {
                for (int k = j + 1; k < nums.length; k++) {
                    if (nums[i] + nums[j] + nums[k] == 0) {
                        List<Integer> triplet = Arrays.asList(nums[i], nums[j], nums[k]);
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
        for (int i = 1; i < a.length; i++) {
            while (i - 1 >= 0 && a[i - 1] > a[i]) {
                exch(a, i - 1, i--);
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

class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
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
