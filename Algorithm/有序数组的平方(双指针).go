
// 给你一个按 非递减顺序 排序的整数数组 nums，返回 每个数字的平方 组成的新数组，要求也按 非递减顺序 排序。
// nums = [-4,-1,0,3,10] 平方后最大的只可能在两头取到,双指针比较两侧平方,较大的取出,较小的等待.由于非递减排序,数组倒序填充,需要一个新数组的队尾指针n
func sortedSquares(nums []int) []int { //leetcode 0977
	l, r, n := 0, len(nums)-1, len(nums)-1
	s := make([]int, n+1, n+1)
	pow := func(i int) int {
		return i * i
	}

	for {
		if l > r {
			break
		}
		if powL, powR := pow(nums[l]), pow(nums[r]); powL > powR {
			s[n] = powL
			n--
			l++

		} else {
			s[n] = powR
			n--
			r--
		}
	}
	return s
}
