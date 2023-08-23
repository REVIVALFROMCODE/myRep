//104
func maxDepth(root *TreeNode) int {
	if root == nil {
		return 0
	}
	return 1 + max(maxDepth(root.Left), maxDepth(root.Right))
} //自底向上返回的时候自加1,避免了自顶向下判断左右节点
func max(a, b int) int {
	if a > b {
		return a
	} else {
		return b
	}
}
