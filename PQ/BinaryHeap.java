package org.PQ;
/*
Based on complete binary tree
 */
public class BinaryHeap <Key extends Comparable<Key>> extends MaxPQ{
    private Key[] pq;
    private int N;

    private void swim(int k){

    }

    private void sink(int k){
        while (less(k,2*k)) {
            int j = 2*k;
            if(less(2*k,2*k+1)) j++;
            exch(k,j);
        }
    }

    private boolean less(int i, int j){
        return pq[i].compareTo(pq[j]) < 0;
    }
    private void exch(int i, int j){
        
    }
}
