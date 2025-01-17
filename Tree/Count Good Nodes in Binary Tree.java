/*
Given a binary tree root, a node X in the tree is named good if in the path from root to X there are no nodes with a value greater than X.

We need to pass current max value by level... Because with recursive traversal, max value may update by DFS which lead to unexpected result.

A valid approach is for each father node, pass to son node a copy of current max rather a same reference to all nodes...
*/
class Solution {
    public int goodNodes(TreeNode root) {
        if(root==null) return 1;
        Cnt cnt = new Cnt(0);
        traverse(root,cnt,root.val);
        return cnt.cnt;
    }
    private class Cnt{
        int cnt;
        Cnt(int cnt){
            this.cnt=cnt;
        }
    }
    private void traverse(TreeNode root,Cnt cnt,int fVal){
        if(root==null) return;
        
        if(root.val >= fVal){
            fVal=root.val;
            cnt.cnt++;
        }
        
        traverse(root.left,cnt,fVal);
        traverse(root.right,cnt,fVal);
    }
}
