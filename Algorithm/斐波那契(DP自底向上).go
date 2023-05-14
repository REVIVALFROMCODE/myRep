func fib(n int) int {//leetcode 509
    var a,b = 0,1
    if n==0{
        return a 
    }
    if n==1{
        return b
    }
    for i:=0;i<n;i++{
        a,b=b,a+b
    }
    return a
}
