import java.util.NoSuchElementException;

public class Queue<Item> {
    private Node<Item> first;
    private Node<Item> last;
    private int n;

    private class Node<Item> {
        private Item item;
        private Node<Item> next;

        public Node(Item item) {this.item=item; this.next=null;}
    }

    public Queue(){
        first = null;
        last = null;
        n = 0;
    }

    public boolean isEmpty(){
        return first == null;
    }


    public void enqueue(Item item){
        Node<Item> oldlast = last;
        last = new Node<Item>(item);
        if (isEmpty()) first = last;
        else           oldlast.next = last;
        n++;
    }

    public Item dequeue(){
        if (isEmpty()) throw new NoSuchElementException("Queue underflow");
        Item item = first.item;
        first = first.next;
        n--;
        if (isEmpty()) last = null;   // to avoid loitering
        return item;
    }
}
