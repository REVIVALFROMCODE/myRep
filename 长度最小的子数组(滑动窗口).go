func minSubArrayLen(target int, nums []int) int {//leetcode 0209
    l,r,sum,length,minLen:=0,0,0,0,199999
    min:=func(i,j int)int{
        if i<j{
            return i
        }else{
            return j
        }
    }
    for r=0;r<len(nums);r++{//右侧边界先贪心扩大
        sum+=nums[r]
        for sum>=target{//符合条件后,收缩左侧边界
            length=r-l+1
            minLen=min(minLen,length)
            sum-=nums[l]
            l++
        }
    }
    if minLen==199999{
        return 0
    }
    return minLen
}
