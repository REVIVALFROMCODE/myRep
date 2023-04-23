func removeElement(nums []int, val int) int { //leetcode:0027
	slow, fast, l := 0, 0, len(nums)
	for fast = 0; fast < len(nums); fast++ {
		if nums[fast] != val { //不删除的赋值后,fast和slow一起走
			nums[slow] = nums[fast]
			slow++
		} else { //这里找到要删除的fast走,slow不走.即fast跳过一个,slow等待fast找到下一个不删除的去赋值给slow
			l--    //这里fast在for里自动走,slow不操作就不走,不用做任何操作.记录数组长度即可.
		}
	}
	nums = nums[:l]
	return l
}
