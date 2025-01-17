
class Solution {
    
    public int maxLevelSum(TreeNode root) {
        int res=0;
        int max=Integer.MIN_VALUE;
        int level=0;
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()){
            int sum =0;
            int sz = q.size();
            level++;
            for(int i=0;i<sz;i++){
                TreeNode cur = q.poll();
                sum+=cur.val;
                if(cur.left!=null) q.add(cur.left);
                if(cur.right!=null) q.add(cur.right);

            }
            if(sum>max) {
                res=level;
                max=sum;
            }
            
        }
        return res;
    }
    
}
