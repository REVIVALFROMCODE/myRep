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
		row := make([]int, 0, size)//满二叉树,每一层row有2^n个节点,实际情况是队列长度个节点.但队列还要不断装入子节点,故记录size.
		for i := 0; i < size; i++ {//遍历每一层初始状态节点.
			cur := q.pop()//2.出队
			row = append(row, cur.Val)//3.记录

			q.push(cur.Left)//4.son进queue
			q.push(cur.Right)
		}
		res = append(res, row)//5.[]append进[][],直接操作[][]太复杂.
	}
	return res
}
