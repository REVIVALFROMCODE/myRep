

public class Solution {//530
    Stack s=new Stack();

    private class Stack{
        int vals[];
        int N;
        Stack(){
            vals=new int[10];
        }
        void resize(int sz){
            int[] dup=new int[sz];
            for(int i=0;i<vals.length;i++) dup[i]=vals[i];
            vals=dup;
        }
        void push(int v){
            if(N==vals.length) resize(2*N);
            vals[N++]=v;
        }
        int pop(){
            if(isEmpty()) return Integer.MAX_VALUE;
            return vals[--N];
        }
        boolean isEmpty(){
            return N==0;
        }
    }
    public int getMinimumDifference(TreeNode root){
        int min=Integer.MAX_VALUE;
        inorder(root);
        int v1 = s.pop();
        while(!s.isEmpty()){
            int v2 = s.pop();
            min = Math.min(min, v1-v2);
            v1=v2;
        }
        return min;
    }
    public void inorder(TreeNode root){
        if(root==null) return;
        inorder(root.left);
        s.push(root.val);
        inorder(root.right);
    }
}
//Solution2 break standard stack, iterate internal array
class Solution {
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
            if(N==vals.length) resize(2*N);
            vals[N++] =v;
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
        int min = Integer.MAX_VALUE;
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


//Solution3 No stack, calculate min during inorder
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


//Solution4 Do not use global variable, instead we pass a structure
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
