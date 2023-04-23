/**
 * Definition for a binary tree node.
 * type TreeNode struct {
 *     Val int
 *     Left *TreeNode
 *     Right *TreeNode
 * }
 *
 *[]int is beyond function,as global value.Here is the trick , no need to pass the slice.
 *If you make slice as parameter but no return is totally wrong.
 *Nothing will append in slice.
 *The reason why is you pass the struct by value,eventhough the base array pass by ptr,length and capacity which is integer type never update.
 *The value is writen in memory in same base array but len and cap dont knonw that.
 *leetcode 0144 preorderTraversal,0094 inorderTraversal,0145 postorderTraversal
 */
func preorderTraversal(root *TreeNode) []int {
    values:=make([]int,0,100)
    var help func(*TreeNode)
    help=func(root *TreeNode){
        if root==nil{
            return
        }
        values=append(values,root.Val)
        help(root.Left)
        help(root.Right)
    }
    help(root)
    return values
}
