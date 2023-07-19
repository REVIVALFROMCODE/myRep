//leetcode 77,Given two integers n and k, return all possible combinations of k numbers chosen from the range [1, n].
func combine(n int, k int) [][]int {
	var (
		chosen []int   = make([]int, 0)
		ans    [][]int = make([][]int, 0)
		recur  func(i int)
	)
	recur = func(i int) {
		//cut (nums alreay acceed k)||(nums plus all remained < k)
    //if not cut,it will slow 3 times than cut.Yes,just a if bring 3 times performance.
		if l := len(chosen); (l == k+1) || (l+n-i+1) < k {
			return
		}
		//normal recur edge
		if i == n+1 {
			//if len(chosen) == k { 
      //doesn't need this if you cut , recur is depth search,which means this function will go around all possibilities.
      //You cut all useless branch,when i get to end(which is n+1),it must be a quanlified chosen.
				s := append(make([]int, 0, len(chosen)), chosen...)
				ans = append(ans, s)
			//}
			return
		}
		recur(i + 1) //dont choose this,then just ask next number.
    {//or choose this
		  chosen = append(chosen, i)
		  recur(i + 1)
		  chosen = chosen[:len(chosen)-1]
    }
	} //func recur
	recur(1)
	return ans
}
