/*

        10
      5          -3
  3        2        11
3   -2        1


tgt = 8
[5,3], [5,2,1], [-3,11]
return 3


*/
//GOAL You are given a binary tree and a target sum. You need to count the number of paths that sum to the given target.
//Solution1 Very slow but works
class Solution {
    int cnt = 0;

    public int pathSum(TreeNode root, int targetSum) {
        dfs(root, targetSum);
        return cnt;
    }

    private ArrayList<Long> dfs(TreeNode root, int targetSum) {
        if (root == null)
            return null;
        ArrayList<Long> cur = new ArrayList<>();
        if (root.left == null && root.right == null) {
            if (root.val == targetSum)
                cnt++;
            cur.add((long) root.val);
            return cur;
        }
        // left
        if (root.left != null)
            for (Long val : dfs(root.left, targetSum)) {
                Long sum = val + root.val;
                if (sum == targetSum) {
                    cnt++;
                }
                cur.add(sum);
            }

        // root
        if (root.val == targetSum)
            cnt++;
        cur.add((long) root.val);

        // right
        if (root.right != null)
            for (Long val : dfs(root.right, targetSum)) {
                Long sum = val + root.val;
                if (sum == targetSum) {
                    cnt++;
                }
                cur.add(sum);
            }
        return cur;
    }
}

/*
Solution2 Consider we store prefixSum:count in Map, for each node we check (current sum - tgt ) = possible_prefix_sum whether exists in map or not, 
if it is, then must exist a valid path, Why? Abstract prefix sum as a sum of sub tree, which plus tgt equal to current sum, then a sub tree with sum equal to tgt must exists.
For instance, tgt=6, path from top to bottom: 10 -> 5 -> 3 -> 3, current sum=21 - tgt = 15 which exist in map(10+5), thus a valid path must exists(3->3).
In above instance, 10->5 is prefix subtree, 3-> 3 is solution subtree.
Because we need to check below directly, put prefix sum backward in map is neccessary. As for same root 5 left:5->3->-2, right:5->2->1 path -2->3->5->2->1 with sum = 9 which equal to 9 is not a valid solution.
*/
class Solution {
    public int pathSum(TreeNode root, int sum) {
        Map<Long, Integer> prefixSum = new HashMap<>();
        prefixSum.put(0L, 1); // Base case to handle exact match with target sum
        return dfs(root, 0L, sum, prefixSum);
    }

    private int dfs(TreeNode node, long currSum, int target, Map<Long, Integer> prefixSum) {
        if (node == null) {
            return 0;
        }

        currSum += node.val;
        int numPathsToCurr = prefixSum.getOrDefault(currSum - target, 0);
        prefixSum.put(currSum, prefixSum.getOrDefault(currSum, 0) + 1);

        int result = numPathsToCurr + dfs(node.left, currSum, target, prefixSum)
                + dfs(node.right, currSum, target, prefixSum);

        // Backtracking
        prefixSum.put(currSum, prefixSum.get(currSum) - 1);

        return result;
    }
}
