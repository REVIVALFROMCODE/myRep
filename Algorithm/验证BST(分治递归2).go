/**
 * Definition for a binary tree node.
 * type TreeNode struct {
 *     Val int
 *     Left *TreeNode
 *     Right *TreeNode
 * }
 */
import "math"
//递归2之: 用递归实现分而治之.母问题可分解为数个子问题,子问题可以同样的方法分解,向下分别解出,向上合并子解得母解.
//例如当前问题,要求 左子树<root.val<右子树,分解后的子树也要符合(递归).其解为左右分解后取交集(分治).
//具体解法为自顶向下递归调用,分治时向下更新root.Val和min,max边界值.以root.Val不符合min,max为false终止或以nil为true返回出口.母问题等待左右子树root递归调用返回取交集.
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
