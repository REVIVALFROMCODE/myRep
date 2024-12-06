public class Solution {
    public boolean isValidBST(TreeNode root) {
        return isValidBST(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    private boolean isValidBST(TreeNode node, long min, long max) {
        if (node == null) return true;

        if (node.val <= min || node.val >= max) return false;

        return isValidBST(node.left, min, node.val) && isValidBST(node.right, node.val, max);
    }
}
/*
         5
    4         6
3       7
7 violate BST. As bigger than root, solution below cannot tell it.
*/
class Solution {
    public boolean isValidBST(TreeNode root) {
        if(root==null) return true;

        if(root.left==null && root.right==null) return true;

        boolean res = true;

        if(root.left==null){
            res = isValidBST(root.right) && root.right.val > root.val;
        }else if(root.right==null){
            res = isValidBST(root.left) && root.left.val < root.val;
        }else{
            if(root.left.val >= root.val || root.right.val <= root.val) res = false;
        }

        return res && isValidBST(root.left) && isValidBST(root.right);
    }
}

class Solution {
    public boolean isValidBST(TreeNode root) {
        if(root.left==null || root.right==null) return root.left == root.right;

        if(root.left.val > root.val || root.right.val < root.val) return false;

        return isValidBST(root.left) && isValidBST(root.right);

    }
}
