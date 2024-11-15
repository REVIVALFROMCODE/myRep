package org.PQ;
/*
A implement of MaxPQ, with unordered design
Insert with O(1), find with O(n)
Elementary priority queue

Analyze
order of growth of finding the largest M in a stream of N items : in M*N time,
 */
public class UnOrderedMaxPQ<Key extends Comparable<Key>> extends MaxPQ{
    private Key[] pq;
    private int N;
    public UnOrderedMaxPQ() {
        super();
    }
    public UnOrderedMaxPQ(int capacity){
        pq= (Key[])new Comparable[capacity];
    }

    @Override
    public void insert(Comparable k) {
        pq[N++]=(Key)k;
    }

    @Override
    public Comparable delMax() {
        int max=0;
        for(int i=1;i<N;i++){
            if(pq[max].compareTo(pq[i])<0){
                max=i;
            }

        }
        //exchange max and N-1
        Key temp=pq[max];
        pq[max]=pq[N-1];
        pq[N-1]=temp;

        return pq[--N];
    }

    @Override
    public Comparable Max() {
        int max=0;
        for(int i=1;i<N;i++){
            if(pq[max].compareTo(pq[i])<0){
                max=i;
            }
        }
        return max;
    }
}
