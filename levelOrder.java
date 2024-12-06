class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();

        if(root==null) return result;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while(!queue.isEmpty()){
            int levelSize = queue.size();
            List<Integer> currentLevel = new ArrayList<>();

            for(int i=0; i< levelSize; i++){//Iterate queue by fixed size, as we must iterate levelly
                TreeNode currentNode = queue.poll();
                currentLevel.add(currentNode.val);
                if(currentNode.left!=null) queue.add(currentNode.left);
                if(currentNode.right!=null) queue.add(currentNode.right);
            }
            //save current level, move forward to next level
            result.add(currentLevel);
        }
        return result;
    }
}


//Solution 2, implement queue manually, we don't have to change any code in solution as we implement same interface: add,poll,isEmpty,size.
class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if(root==null) return res;
        queue<TreeNode> q = new queue<>();

        q.add(root);

        while(!q.isEmpty()){
            int currentSize = q.size();
            List<Integer> currentLevel = new ArrayList<>();

            for(int i =0;i<currentSize;i++){
                TreeNode currentNode = q.poll();
                currentLevel.add(currentNode.val);
                if(currentNode.left!=null) q.add(currentNode.left);
                if(currentNode.right!=null) q.add(currentNode.right);
            }
            res.add(currentLevel);
        }
        return res;
    }

    private class queue<Item>{
        private class Node{//Inner class do not need <Item>
            Item val;
            Node next;

            Node(Item x){
                val=x;
            }
        }
        Node prior;
        Node tail;
        int N;
        void add(Item x){
            Node newNode = new Node(x);
            if(isEmpty()){
                tail = newNode;
                prior=tail;
            }else{
                tail.next=newNode;
                tail=tail.next;
            }
            N++;
        }

        Item poll(){
            Item val = prior.val;
            prior=prior.next;
            N--;
            if(isEmpty()) tail=prior;//=null
            return val;
        }

        boolean isEmpty(){
            return prior==null;
            //or N==0
        }

        int size(){
            return N;
        }
    }
}
