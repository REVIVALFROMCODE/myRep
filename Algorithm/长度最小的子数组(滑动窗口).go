func minSubArrayLen(target int, nums []int) int {
var (
		zero  = int(0)
		l		  = zero
		r		  = zero
		sum		= zero
		length	= zero
		minLen 	= int(1e9)
	)
	min := func(i, j int) int {
		if i < j {
			return i
		} else {
			return j
		}
	}
	for r = 0; r < len(nums); r++ {//plus right until sum get to target
		sum += nums[r]
		for sum >= target {//contract left , it may have better solution in window
			length = r - l + 1 // key clause
			sum -= nums[l]
			minLen = min(minLen, length)
			l++
		}
	}
		if minLen == int(1e9) {
		return 0
	}
	return minLen
}
