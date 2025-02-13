class Solution {
    public int fib(int n) {
        if(n<2) return n;
        int p=0;
        int q=0;
        int r=1;
        for(int i=1;i<n;i++){
            p=q;
            q=r;
            r=p+q;//i=1; n=2 r=0+1=1
        }
        return r;
    }
}
