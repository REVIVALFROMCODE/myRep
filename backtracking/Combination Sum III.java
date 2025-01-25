/*
Expected sum == n, number of number == k
Input: k = 3, n = 9
Output: [[1,2,6],[1,3,5],[2,3,4]]
Explanation:
1 + 2 + 6 = 9
1 + 3 + 5 = 9
2 + 3 + 4 = 9
There are no other valid combinations.
*/
class Solution {
    int[] params = new int[] {
            1, 2, 3, 4, 5, 6, 7, 8, 9
    };

    public List<List<Integer>> combinationSum3(int k, int n) {
        return backTrack(0, 0, k, n, 0, new int[k], new ArrayList<List<Integer>>());

    }
    /*
    i: number of numbers, index of nums
    p: index of params
    k: input
    n: input
    sum: intermidiate sum
    nums: intermidiate res
    */
    List<List<Integer>> backTrack(int i, int p, int k, int n, int sum, int[] nums, List<List<Integer>> res) {
        if (sum > n)
            return null;
        if (i == k) {
            if (sum != n)
                return null;
            List<Integer> integerList = new ArrayList<>();
            for (int z : nums) {
                integerList.add(z);
            }
            res.add(integerList);
            return null;
        }
        for (int j = p; j < 9; j++) {
            nums[i] = params[j];
            sum += params[j];
            backTrack(i + 1, j + 1, k, n, sum, nums, res);
            sum -= params[j];
        }
        return res;
    }
}
