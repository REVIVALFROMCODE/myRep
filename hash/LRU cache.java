/*
int get(int key) Return the value of the key if the key exists, otherwise return -1.
void put(int key, int value) Update the value of the key if the key exists. 
Otherwise, add the key-value pair to the cache. If the number of keys exceeds the capacity from this operation, evict the least recently used key.
The functions get and put must each run in O(1) average time complexity.
*/

/*
Solution1 implement dual linked list.

To implement least recently used cache, move element behind dummy after each get/set.
To move element behind dummy, we remove it then put it behind dummy.
*/
public class LRUCache {
    // Node class for doubly linked list
    class DLinkedNode {
        int key;
        int value;
        DLinkedNode prev;
        DLinkedNode next;
        public DLinkedNode() {}
        public DLinkedNode(int _key, int _value) {key = _key; value = _value;}
    }

    // Hash map to store key and corresponding node
    private Map<Integer, DLinkedNode> cache = new HashMap<Integer, DLinkedNode>();
    private int size;
    private int capacity;
    private DLinkedNode head, tail;

    // Initialize LRUCache with specified capacity
    public LRUCache(int capacity) {
        this.size = 0;
        this.capacity = capacity;
        // Create dummy head and tail nodes
        head = new DLinkedNode();
        tail = new DLinkedNode();
        head.next = tail;
        tail.prev = head;
    }

    // Retrieve value from cache by key
    public int get(int key){
        DLinkedNode node = cache.get(key);
        if(node!=null){
            moveForward(node);
            return node.value;
        }else {
            return -1;
        }
    }
    // Insert or update a key-value pair in the cache
    public void put(int key,int value){
        DLinkedNode node = cache.get(key);
        if(node!=null){
            node.value=value;
            moveForward(node);
        }else{
            node=new DLinkedNode(key,value);
            cache.put(key,node);
            addAsHead(node);
            if(++size > capacity){
                int tailKey = removeTail();
                //We need key for remove tail from cache, with O(1) time. So we have to reserve key in node.
                cache.remove(tailKey);
                size--;
            }
        }
    }
    public void moveForward(DLinkedNode node){
        removeNode(node);
        addAsHead(node);
    }
    public void removeNode(DLinkedNode node){
        node.prev.next=node.next;
        node.next.prev=node.prev;
    }
    public void addAsHead(DLinkedNode node){
        node.next=head.next;
        head.next=node;
        node.prev=head;
        node.next.prev=node;
    }
    public int removeTail(){
        int key = tail.prev.key;
        removeNode(tail.prev);
        return key;
    }
}



class LRUCache {
    private final int capacity;
    private final Map<Integer,Integer> map;
    private final LinkedHashSet<Integer> set;
    public LRUCache(int capacity) {
        this.capacity=capacity;
        map=new HashMap<>();
        set=new LinkedHashSet<>();
    }

    public int get(int key) {
        if(!map.containsKey(key)) return -1;
        // Move the accessed key to the end to show that it was recently used
        set.remove(key);
        set.add(key);
        return map.get(key);
    }

    public void put(int key, int value) {
        if(map.containsKey(key)){
            set.remove(key);
        }else if(map.size()==capacity){
            // If the number of keys exceeds the capacity from this operation, evict the least recently used key.
            int oldest = set.iterator().next();
            set.remove(oldest);
            map.remove(oldest);
        }
        map.put(key,value);
        set.add(key);
    }
}




class LRUCache extends LinkedHashMap<Integer, Integer> {
    private final int capacity;

    public LRUCache(int capacity) {
        super(capacity, 0.75f, true);
        this.capacity = capacity;
    }

    @Override
    protected boolean removeEldestEntry(Map.Entry<Integer, Integer> eldest) {
        return size() > capacity;
    }

    public int get(int key) {
        return super.getOrDefault(key, -1);
    }

    public void put(int key, int value) {
        super.put(key, value);
    }
}
