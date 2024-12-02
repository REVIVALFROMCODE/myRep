/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        
        if ((p == null && q != null) || (p != null && q == null)) return false;  //if one of p,q is null, but another one is not, false.
        
        if (p==null && q==null) return true;  //both are null, true;
        
        if(p.val!=q.val) return false;  //different val, false;
        
        if (!isSameTree(p.left,q.left)) return false;  //recusive call left and right, if one of them not true, false.
        if (!isSameTree(p.right,q.right)) return false;
        
        return true;  //pass all examine , true
    }
}

class Solution {//compacter version, no differ on performance.
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null || q == null) return p == q;
        return p.val == q.val && isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }
}
