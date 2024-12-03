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
