/**
 * Definition for a binary tree node.
 * type TreeNode struct {
 *     Val int
 *     Left *TreeNode
 *     Right *TreeNode
 * }
 */
func preorderTraversal(root *TreeNode) []int {//leetcode 0144 preorderTraversal,0094 inorderTraversal,0145 postorderTraversal
    values:=make([]int,0,100)//[]int is beyond function,as global value
    var help func(*TreeNode)
    help=func(root *TreeNode){//if you make []int as parameter but no return is totally wrong.Nothing will change in slice.
        if root==nil{//maybe you can pass &[]int as parameter.
            return
        }
        values=append(values,root.Val)
        help(root.Left)
        help(root.Right)
    }
    help(root)
    return values
}
