/**
 * Definition for a binary tree node.
 * type TreeNode struct {
 *     Val int
 *     Left *TreeNode
 *     Right *TreeNode
 * }
 */
import "math"

func isValidBST(root *TreeNode) bool {
	var DAC func(root *TreeNode, min, max float64) bool
	DAC = func(root *TreeNode, min, max float64) bool {
		if root == nil { //base
			return true
		}
		if val := float64(root.Val); val < max && val > min {
			//divide and conquer
			return DAC(root.Left, min, val) && DAC(root.Right, val, max) //combine
			//左边要求小,更新最大值为val.		右边要求大,更新最小值为val.
		} else {
			return false
		}
	}
	return DAC(root, math.Inf(-1), math.Inf(1)) //math.Inf()pass negative,return the min value (type:float64)
}
