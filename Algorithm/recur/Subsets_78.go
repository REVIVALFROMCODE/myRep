//leetcode 78,Given an integer array nums of unique elements, return all possible subsets (the power set).
func subsets(nums []int) [][]int {
	var (
		n      int     = len(nums)
		chosen []int   = make([]int, 0)
		ans    [][]int = make([][]int, 0)
		recur  func(i int)
	)
	//每一次面对num[i]这1个数,选或不选.相似过程递归
	recur = func(i int) {
		if i == n {
			s := append(make([]int, 0, len(chosen)), chosen...)
			//Otherwise,append chosen will change underlying array in following codes to occur wrong things.
			ans = append(ans, s)
			return
		}

		recur(i + 1) //不选
		//选
		chosen = append(chosen, nums[i])
		recur(i + 1)
		chosen = chosen[:len(chosen)-1]
	} //func recur
	recur(0)
	return ans
}
