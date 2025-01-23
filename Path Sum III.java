/*

        10
      5          -3
  3        2        11
3   -2        1


tgt = 8
[5,3], [5,2,1], [-3,11]
return 3


*/

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
