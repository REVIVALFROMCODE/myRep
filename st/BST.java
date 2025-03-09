package org.ST;

public class BST<Key extends Comparable<Key>, Value> {
    private class Node {
        private Key key;
        private Value val;
        private Node left, right;

        public Node(Key key, Value val) {
            this.key = key;
            this.val = val;
        }
    }

    private Node root;

    public Value get(Key key) {
        /*
        takes proportion to height of tree time to insert N nodes
        expected height of tree is 4.311 ln N
        average of search hit or insert is 1.39 lg N. Compare to binary search lg N and N/2 to search and insert.
        if keys inserted by order or reverse order, worst-case height is N
         */
        Node x = root;
        while (x != null) {
            int cmp = key.compareTo(x.key);
            if (cmp < 0) x = x.left;
            if (cmp > 0) x = x.right;
            else return x.val;
        }
        return null;
    }

    public void put(Key key, Value val) {
        root = put(root, key, val);
    }

    private Node put(Node x, Key key, Value val) {
        /*
        -> x==null -> new Node, (or)x!=null(x.left(re), x.right(re), equal) -> return x
        */
        if (x == null) return new Node(key, val);

        int cmp = key.compareTo(x.key);
        if (cmp < 0) x.left = put(x.left, key, val);
        else if (cmp > 0) x.right = put(x.right, key, val);
        else x.val = val;
        return x;
    }

    public void delete(Key key) {

    }
}
