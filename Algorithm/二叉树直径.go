//543 diameter
func diameterOfBinaryTree(root *TreeNode) int {
	Max := 0
	var helper func(root *TreeNode) int
	helper = func(root *TreeNode) int {
		if root == nil {
			return 0
		}
		if root.Left == nil && root.Right == nil {
			return 1
		}
    //自底向上,最底左右皆空返回1.往上看一层,如左边一个且右边空返回1+0.故得来以上两个递归出口.
		left, right := helper(root.Left), helper(root.Right)
		now := left + right
		Max = max(now, Max)
    //左路右路和是当前节点最大,记录max.往上一层,应是前左右路中最大的一路+1做左或右分支.
		return 1 + max(left, right)
	}
	helper(root)
	//自底到达顶端root后,helper return的max+1在递归时是核心,但在调用入口这里不被需要,
	//而主函数return的是记录的Max,这也是使用helper的目的,奇哉妙也.
	return Max
}
func max(a, b int) int {
	if a > b {
		return a
	} else {
		return b
	}
}
