//102. 注意不使用递归.
type queue struct {
	data []*TreeNode
}

func (q *queue) push(a *TreeNode) {
	if a == nil {
		return
	}
	q.data = append(q.data, a)
}
func (q *queue) pop() *TreeNode {
	defer func() {
		q.data = q.data[1:]
	}()
	return q.data[0]
}
func (q *queue) empty() bool {
	if len(q.data) == 0 {
		return true
	} else {
		return false
	}
}
func levelOrder(root *TreeNode) [][]int {
	if root == nil {
		return nil
	}
	q := &queue{
		data: [](*TreeNode){root},
	} //1.root->Queue
	res := make([][]int, 0, 1)

	for !q.empty() {
		size := len(q.data) //初始状态
		row := make([]int, 0, size)
		for i := 0; i < size; i++ {
			cur := q.pop()
			row = append(row, cur.Val)

			q.push(cur.Left)
			q.push(cur.Right)
		}
		res = append(res, row)
	}
	return res
}
