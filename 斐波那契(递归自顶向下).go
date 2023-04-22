func climbStairs(n int) int {//leetcode 70
    m:=make(map[int]int)//阶:种
    m[1],m[2]=1,2
        //init
    //From top to below
    var do func (n int)int
    do=func (n int)int{
        if val,ok:=m[n];ok{
            return val
        }else{
            m[n]=do(n-1)+do(n-2)
            return m[n]
        }
    }
    return do(n)
}
//0,1,1,2,3 种方法
//    1,2,3 阶
