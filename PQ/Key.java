package org.PQ;
/*
<T extends Comparable<T>> : parameter T implements Comparable
implements Comparable<Key<T>> : Key<T> implements Comparable
 */
public class Key <T extends Comparable<T>> implements Comparable<Key<T>>{
    T val;
    @Override
    public int compareTo(Key<T> o) {
        return this.val.compareTo(o.val);
    }
}
