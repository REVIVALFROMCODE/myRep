class Solution {//530
    stack s = new stack();

    private class stack{
        int vals[];
        int N;
        stack(){
            this(10);
        }
        stack(int len){
            vals = new int[len];
            N=0;
        }
        void push(int v){
            vals[N++] =v;
            if(N==vals.length) resize(2*N);
        }
        void resize(int len){
            int dup[] = new int[len];
            for(int i =0; i< vals.length;i ++){
                dup[i] = vals[i];
            }
            vals = dup;
        }
        int[] getArray(){
            int res[] = new int[N];
            for(int i =0; i< N;i ++){
                res[i] = vals[i];
            }
            return res;
        }
    }

    public int getMinimumDifference(TreeNode root) {
        int min = 999999;
        if(root == null) return min;
        inOrderTraversal(root);
        int res[] = s.getArray();
        
        for(int i = 1 ; i< res.length; i++){
            int val = res[i] - res[i-1];
            min = val<min? val: min;
        }
        return min;
    }

    public void inOrderTraversal(TreeNode root){
        if(root==null) return;
        inOrderTraversal(root.left);
        s.push(root.val);
        inOrderTraversal(root.right);
    }
}


//Solution 2
class Solution {
    private TreeNode prev = null; // Integer used to store null so we used
    private int min = Integer.MAX_VALUE;

    public int getMinimumDifference(TreeNode root) {
        inorderTraversal(root);
        return min;
    }

    private void inorderTraversal(TreeNode root) {
        if (root == null)
            return;
        inorderTraversal(root.left);
        // Calculate the difference with the previous node
        if (prev != null) {
            int val = root.val - prev.val; // No need for Math.abs, as root.val >= previous in BST inorder
            if (min > val)
                min = val;
        }
        // Update the previous value to current node's value
        prev = root;
        inorderTraversal(root.right);
    }
}


//Solution3
class Solution {
    public int getMinimumDifference(TreeNode root) {
        int preMin[] = new int[2];
        preMin[0] = -1;
        preMin[1] = Integer.MAX_VALUE;
        inorderTraver(root,preMin);
        return preMin[1]; 
    }
    public void inorderTraver(TreeNode cur, int[] preMin){
        if(cur==null) return;

        inorderTraver(cur.left, preMin);

        if(preMin[0]>=0){
            if(cur.val - preMin[0]< preMin[1]) preMin[1] = cur.val - preMin[0];
        }
            preMin[0] = cur.val;

        inorderTraver(cur.right, preMin);
    }
}
