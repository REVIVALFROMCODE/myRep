//递归3之 利用递归实现回溯,用于要枚举或排列组合所有可能解的问题.从零出发,递归调用出当前情况的所有可能分支作为尝试.当前题目可提前判断再递归实际上是较为特殊的.直观的方法是递归再剪枝.
func generateParenthesis(n int) []string { //leetcode 22
	res := make([]string, 0)
	var bt func(s string, left, right int)
	bt = func(s string, left, right int) {
		if right == n {//1.下面的两方面尝试,if逻辑保证当前字符串总是正确的.(正确的起点)
      //2.是自底向上的递归尝试,避免了重复的尝试.(正确的步)
      //3.最后一个右括号到达即结束(正确的答案)
			res = append(res, s)
		} else {//左或右,两方面尝试,并列的逻辑,自底向上从无到有的如同分身一分为二叫backtracking
      //(与之相对的,自顶向下分别解答再合并答案叫divide and conquer then combine)
			if left < n {//只要没到达总数,总可以加上左括号,该逻辑一定正确
				bt(s+"(", left+1, right)
			}
			if left > right {//存在左括号等待右括号时,才加右括号,显然总可以匹配
				bt(s+")", left, right+1)
			}
		}
	}
	bt("", 0, 0)
	return res
}
