package org.Queue;

import java.util.Iterator;
import java.util.Spliterator;
import java.util.function.Consumer;

public class Queue<Item> implements Iterable<Item> {
    private Node first;
    private Node last;
    private int N;

    public Queue() {
        first = new Node();
        last = first;
        N = 0;
    }

    private class Node {
        Item item;
        Node next;

        public Node() {

        }

        public Node(Item item) {
            this.item = item;
        }

        public Node(Item item, Node next) {
            this.item = item;
            this.next = next;
        }
    }

    public boolean isEmpty() {
        return N == 0;
    }

    public void enqueue(Item item) {
        last.next = new Node(item);
        last = last.next;
        N++;
    }

    public Item dequeue() {
        if (isEmpty()) {
            //throw exception
            return null;
        } else {
            Item item = first.next.item;
            first.next = first.next.next;
            N--;
            if(isEmpty()) last=first;
            return item;
        }
    }
    private class QueueIterator implements Iterator<Item>{
        Node current = first.next;
        @Override
        public boolean hasNext() {
            return current!=null;
        }

        @Override
        public Item next() {
            Item item = current.item;
            current = current.next;
            return item;
        }
    }
    @Override
    public Iterator<Item> iterator() {
        return new QueueIterator();
    }

    @Override
    public void forEach(Consumer<? super Item> action) {
        Iterable.super.forEach(action);
    }

    @Override
    public Spliterator<Item> spliterator() {
        return Iterable.super.spliterator();
    }
}
