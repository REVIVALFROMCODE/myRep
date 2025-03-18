
class Solution {
    public boolean isValidBST(TreeNode root) {
        return isValidBST(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    public boolean isValidBST(TreeNode root, long min, long max) {
        if (root == null)
            return true;

        if (root.val <= min || root.val >= max)
            return false;// if violate BST, false;
        return isValidBST(root.left, min, root.val)// forward boundary
                && isValidBST(root.right, root.val, max);
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
