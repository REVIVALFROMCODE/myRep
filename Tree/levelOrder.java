/*
GOAL:    level orderly tranversal binary tree. 
ALGO:    put root enqueue and start while loop until queue is empty, new Array according size of queue and start for loop interate queue, 
         put each son Node enquue and add val in Array as one level. Put Array in res at the end of while loop.
DS:      Queue<TreeNode> for saving candidate Nodes, as we traverse by size of queue, following Nodes will not be traverse wrongly.
         List<List<Integer>> for saving result.
         List<Integer> currentLevel for each round, 
*/
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

/*
ALGO: in each level, we locate associated Array by Array.get(level), and iterate Nodes recursively with param (int level)
DS:         List<List<Integer>> result and we get Array by result.get(level)
*/

//Solution 3: Recursive call with parameters: int level
public class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        levelOrder(root, 0, result);
        return result;
    }

    private void levelOrder(TreeNode node, int level, List<List<Integer>> result) {
        if (node == null) return;

        // Ensure the list is large enough to hold the current level, result.get(level) do not exist.
        if (result.size() <= level) {
            result.add(new ArrayList<>());
        }

        // Add the current node value to the correct level
        result.get(level).add(node.val);

        // Recursive calls for left and right children
        levelOrder(node.left, level + 1, result);
        levelOrder(node.right, level + 1, result);
    }
}

