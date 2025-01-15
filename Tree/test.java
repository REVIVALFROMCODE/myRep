    public static void main(String[] args) {
        new Solution();
    }

    static class TreeNode{
            TreeNode left;
            TreeNode right;
            int val;
            TreeNode(int val){this.val=val;}
      }
    /*
      Input: root = [3,9,20,null,null,15,7]
      Output: 3
    */
        static {
            TreeNode root;
            root = new TreeNode(3);
            root.left = new TreeNode(9);
            root.right = new TreeNode(20);
            root.right.left
                    = new TreeNode(15);
            root.right.right = new TreeNode(7);
            maxDepth(root);
        }
        public static int maxDepth(TreeNode root) {
            if (root == null) {
                return 0;
            }
            int leftDepth = maxDepth(root.left);
            int rightDepth = maxDepth(root.right);
            return Math.max(leftDepth, rightDepth) + 1;
        }
