func removeElement(nums []int, val int) int {//leetcode:0027
    slow,fast,l:=0,0,len(nums)
    for fast=0;fast<len(nums);fast++{
        if nums[fast]!=val{//不删除的赋值后,fast和slow一起走
            nums[slow]=nums[fast]
            slow++;
        }else{//要删除的fast走,slow不走
            l--
        }
    }
    nums=nums[:l]
    return l
}
