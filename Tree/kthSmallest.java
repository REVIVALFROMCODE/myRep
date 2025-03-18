/*
Solution one, 

In order to find k the smallest element of BST.

[5,3,6,2,4,null,null,1]
k=3
Expected: 3
As, sorted array is 1,2,3,4,5,6. 3 is rank(3)

To do this, we traversal BST inorderly, increment count on position of current node, if counter hits k -> return method. 

It's return order just like sorted order
*/
class Solution {
    int counter = 0;
    int res = 0;

    public int kthSmallest(TreeNode root, int k) {

        inOrder(root, k);
        return res;
    }

    private void inOrder(TreeNode node, int k) {
        if (node == null) return;
        inOrder(node.left, k);

        // Increment the counter
        counter++;
        if (counter == k) {
            res = node.val; // Found kth smallest
            return;
        }

        inOrder(node.right, k);
    }
}


class Solution {
    public int kthSmallest(TreeNode root, int k) {
        /*solution 2:
            Kth smallest element 

            max heap with size k, implement heap with array, 2*k and 2*k+1 are childrens, k/2 is father.

            once current value smaller than max element of heap(only if heap is already full), we insert it.

            As a result, heap reserve k smallest elements. rank k is the root.

            [5,3,6,2,4,null,null,1]
            k=3
            heap: 5,3     insert 6 as heap not full
            ->    6,5,3   insert 2 as 2 < 6
            ->    5,2,3   insert 4 as 4 < 5
            ->    4,2,3   insert 1 as 1 < 4
            ->    3,2,1
        */
        heap h = new heap(k);
        pushTree(root, h);
        return h.delMax();
    }

    private void pushTree(TreeNode root, heap h) {
        if (root == null) return;
        h.push(root.val);
        pushTree(root.left, h);
        pushTree(root.right, h);
    }

    class heap {
        int[] val;
        int N;//insert N++, remove --N;


        heap(int capacity) {
            val = new int[capacity + 1];
            N = 1;
        }


        void exch(int i, int j) {
            int temp = val[j];
            val[j] = val[i];
            val[i] = temp;
        }


        boolean less(int i, int j) {
            return val[i] < val[j];
        }


        void swim(int n) {
            int fIndex = n / 2;

            while (fIndex >= 1) {
                if (less(fIndex, n)) { //root is the biggest, if father less than current, exchange.
                    exch(fIndex, n);
                } else break;
                n = fIndex;
                fIndex = n / 2;
            }
        }


        void push(int x) {

            if (N == val.length) {
                if (x < val[1]) delMax();
                else return;
            }

            val[N] = x;

            swim(N);

            N++;
        }


        void sink(int n) {
            int cIndex = 2 * n;
            while (cIndex + 1 < N) { //N points to out of bound when heap is full, since below visit cIndex+1, compare
                if (less(n, cIndex) || less(n, cIndex + 1)) { //violate max heap order
                    if (less(cIndex, cIndex + 1)) cIndex = cIndex + 1;
                    if (val[cIndex] == -1) break; //loiter
                    exch(cIndex, n);
                } else break;
                n = cIndex;
                cIndex = 2 * n;
            }
        }


        int delMax() {
            int res = val[1];
            exch(1, N - 1); //N points to out of bound when heap is full
            val[N - 1] = -1;
            sink(1);
            N--;
            //val[N] = null;
            return res;
        }

        int max() {
            return val[1];
        }
    }
}
