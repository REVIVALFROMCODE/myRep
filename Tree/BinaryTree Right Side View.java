/*
Input: root = [1,2,3,null,5,null,4]

Output: [1,3,4]

GOAL:    1
2           3
    5           4
Output right view [1,3,4].

ALgo: Perform level traversal,  put the last value of each level in result set.
For each level, iterate by size of queue, once reach the last one we put it in result set.
Ds: A stack for performing level traversal. 
    A array list for result set.
 */
class Solution {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> rightView = new ArrayList<>();
        if (root == null)
            return rightView;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            for (int i = 0; i < levelSize; i++) {
                TreeNode currentNode = queue.poll();
                if (i == levelSize - 1) {
                    rightView.add(currentNode.val);
                }
                if (currentNode.left != null) {
                    queue.add(currentNode.left);
                }
                if (currentNode.right != null) {
                    queue.add(currentNode.right);
                }
            }
        }
        return rightView;
    }
}


//Solution2
class Solution {
    List<Integer> result;
    public List<Integer> rightSideView(TreeNode root) {
        this.result = new ArrayList<>();
        dfs(root, 0);
        return result;
    }

    void dfs(TreeNode root, int level) {
        if(root == null) return;

        if(result.size() == level) {
            result.add(root.val);
        }

        dfs(root.right, level+1);
        dfs(root.left, level+1);
    }
}
