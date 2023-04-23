func search(nums []int, target int) int { //leetcode 704
	left, right := 0, len(nums) //[) just like slice[left:right]
	for mid := (left + right) / 2; ; left < right {
		if nums[mid] > target {
			right = mid
			//target在左侧,更新右边界为mid.虽然right=mid 但是右侧开区间并不包含mid,重复包含会导致错误结果.
		} else if nums[mid] < target {
			left = mid + 1
			//target在右侧,更新左边界为mid+1;因为大于mid,mid不可能是target.始终左闭右开区间去判断.
		} else {
			return mid
		}
	}
	return -1
}
