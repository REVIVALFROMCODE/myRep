class Solution {
    int counter =0;
    int res=0;
    public int kthSmallest(TreeNode root, int k) {
        
        inOrder(root, k);
        return res;
    }

    private void inOrder(TreeNode node, int k) {
        if (node == null) return;
        inOrder(node.left, k);
        
        // Increment the counter
        counter++;
        if (counter == k) {
            res = node.val; // Found kth smallest
            return;
        }
        
        inOrder(node.right, k);
    }
}
