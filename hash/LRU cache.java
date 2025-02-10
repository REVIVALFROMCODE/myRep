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
    public int get(int key) {
        DLinkedNode node = cache.get(key);
        if (node == null) {
            return -1; // Return -1 if key doesn't exist
        }
        // Move the accessed node to the head (most recently used)
        moveToHead(node);
        return node.value;
    }

    // Insert or update a key-value pair in the cache
    public void put(int key, int value) {
        DLinkedNode node = cache.get(key);
        if (node == null) {
            // Create a new node if key doesn't exist
            DLinkedNode newNode = new DLinkedNode(key, value);
            cache.put(key, newNode); // Add to hash map
            addToHead(newNode); // Add to the head of the list
            ++size;
            if (size > capacity) {
                // If cache exceeds capacity, remove the tail node (least recently used)
                DLinkedNode tail = removeTail();
                cache.remove(tail.key); // Remove from hash map
                --size;
            }
        } else {
            // Update the value of the existing node and move it to the head
            node.value = value;
            moveToHead(node);
        }
    }

    // Add a node to the head of the linked list
    private void addToHead(DLinkedNode node) {
        node.prev = head;
        node.next = head.next;
        head.next.prev = node;
        head.next = node;
    }

    // Remove a node from the linked list
    private void removeNode(DLinkedNode node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    // Move a node to the head of the linked list
    private void moveToHead(DLinkedNode node) {
        removeNode(node);
        addToHead(node);
    }

    // Remove the tail node from the linked list and return it
    private DLinkedNode removeTail() {
        DLinkedNode res = tail.prev;
        removeNode(res);
        return res;
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
