/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */


 /*
            1. root.val = preorder[preIndex] ; then new TreeNode

            2. Iterate inorder[] , find index of root = inorder[inIndex]

            3. Each round, inIndex partition left tree and right tree in array inorder[].

            inorder[] : [inStart , ... , inIndex -1 , inIndex, inIndex +1, ... , inEnd]
            preIndex is entry of current root and start of subtree
            inStart, inEnd is range of currentTree

            4. Recusive call left tree and right tree.

            5.  root.left = reCall(preIndex= preIndex-1,inStart= inStart,inEnd= inIndex-1)
                root.right = reCall(preIndex=preIndex + inIndex - inStart + 1 ,inStart=inIndex+1 ,inEnd= inEnd)
            preIndex of left subTree is next of current preIndex
            preIndex of right subTree is current preIndex + (number of nodes of left Subtree)
            (number of nodes of left Subtree) is (inorderIndex - inorderStart + 1)         */
         
class Solution {
  public TreeNode buildTree(int[] preorder, int[] inorder) {
    return buildTree(preorder, inorder, 0, 0, inorder.length - 1);
  }
  private TreeNode buildTree(
      int[] preorder, int[] inorder, int preIndex, int inStart, int inEnd) {
    if (inStart > inEnd)
      return null;
    TreeNode root = new TreeNode(preorder[preIndex]);
    int inIndex = inStart;

    for (int i = inStart; i <= inEnd; i++) { //<=
      if (inorder[i] == preorder[preIndex]) {
        inIndex = i;
        break;
      }
    }

    root.left =
        buildTree(preorder, inorder, preIndex + 1, inStart, inIndex - 1);
    root.right = buildTree(preorder, inorder, preIndex + inIndex - inStart + 1,
        inIndex + 1, inEnd);

    return root;
  }
}
