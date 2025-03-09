package org.PQ;
/*
Key must be comparable
 */
public class MaxPQ<Key extends Comparable<Key>> {
    private Key[] pq;
    private int N;
    /*
    construct a empty priority queue
     */
    public MaxPQ(){
    }
    /*
    construct priority queue from group of keys
     */
    public MaxPQ(Key[] keys){
        pq=keys;
        N=keys.length;
    }

    public void insert(Key k){

    }
    /*
    return and remove max Key
     */
    public Key delMax(){
        return null;
    }
    /*
    is priority queue empty?
     */
    public Boolean isEmpty(){
        return N==0;
    }
    /*
    size of PQ
     */
    public int Size(){
        return N;
    }
    /*
    return max element,peek but not remove
     */
    public Key Max(){
        return null;
    }
}
