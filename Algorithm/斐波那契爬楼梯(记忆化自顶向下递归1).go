//模拟倒着走回去,取决于前两项的结果,涉及到重复计算,调用后先查表,返回之前要记录入表.
//并非最优解,最优解为已知是斐波那契从0,1,1开始DP双指针向前走.以上方法重在基础,模拟是比较基础但具有启发性的方法.
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
