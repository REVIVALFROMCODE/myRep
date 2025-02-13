/*
由于斐波那契数存在递推关系，因此可以使用动态规划求解。动态规划的状态转移方程即为上述递推关系，边界条件为 F(0) 和 F(1)。

根据状态转移方程和边界条件，可以得到时间复杂度和空间复杂度都是 O(n) 的实现。由于 F(n) 只和 F(n−1) 与 F(n−2) 有关，因此可以使用「滚动数组思想」把空间复杂度优化成 O(1)。如下的代码中给出的就是这种实现。

*/
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

//斐波那契数 F(n) 是齐次线性递推, 特征方程 r^2=r+1 F（0），F（1）带入通解F(n)=c1 x^n + c2 x^n
class Solution {
    public int fib(int n) {
        double sqrt5 = Math.sqrt(5);
        double fibN = Math.pow((1 + sqrt5) / 2, n) - Math.pow((1 - sqrt5) / 2, n);
        return (int) Math.round(fibN / sqrt5);
    }
}
