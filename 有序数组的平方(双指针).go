// 给你一个按 非递减顺序 排序的整数数组 nums，返回 每个数字的平方 组成的新数组，要求也按 非递减顺序 排序。
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
		if pow(nums[l]) > pow(nums[r]) {
			s[n] = pow(nums[l])
			n--
			l++
		} else {
			s[n] = pow(nums[r])
			n--
			r--
		}
	}
	return s
}
