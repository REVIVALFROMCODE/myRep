package pq;

/*
Based on complete binary tree,level order traversal of tree is sorted order
 */
public class BinaryHeap<Key extends Comparable<Key>> extends MaxPQ<Key> {
    private Key[] pq;//Immutable keys
    private int N;

    private boolean less(int i, int j) {
        return pq[i].compareTo(pq[j]) < 0;
    }

    private void exch(int i, int j) {
        Key t = pq[i];
        pq[i] = pq[j];
        pq[j] = t;
    }
    //heap-ordered parents no smaller than children's keys
    //pq[k/2] >= pq[k] >= pq[2*k] and pq[2*k+1]

    /*
    bottom-up reheapify
    When the priority of some node is increased (or a new node is added at the
    bottom of a heap), we have to travel up the heap to restore the heap order.
    */
    private void swim(int k) {
        // compare with parent k/2, since we represent the heap with array, the
        // exchange is convincing.
        while (k > 1 && less(k / 2, k)) {//less(k/2,k) violate heap-order
            exch(k / 2, k);
            k = k / 2;
        }
    }

    public void insert(Key k) {
        pq[++N] = k;
        swim(N);
    }

    private void sink(int k) {
        // compare to son 2k
        while (2 * k <= N) {
            int j = 2 * k;
            if (j < N && less(j, j + 1))
                j++;
            if (!less(k, j))
                break;
            exch(k, j);
            k = j;
        }
    }

    public Key delMax() {
        Key max = pq[1];//return pq[1]
        exch(1, N--);//exchange with the last one
        sink(1);//re-order it(was last one)
        pq[N + 1] = null;//remove last one(was first one)
        return max;
    }
//1
}
