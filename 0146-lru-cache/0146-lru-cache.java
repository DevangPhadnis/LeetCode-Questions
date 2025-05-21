class Node {
    public Node prev;
    public Node next;
    public int data;
    public int keyData;

    Node(int key, int val) {
        keyData = key; 
        data = val;
        prev = null;
        next = null;
    }
}

class LRUCache {

    Node head, tail;
    int size;
    HashMap<Integer, Node> map = new HashMap<>();
    public LRUCache(int capacity) {
        size = capacity;
        head = new Node(0, 0);
        tail = new Node(0, 0);
        head.next = tail;
        tail.prev = head;
    }
    
    public int get(int key) {
        if(map.containsKey(key)) {
            Node temp = map.get(key);
            insert(key, temp.data);
            return temp.data;
        }
        else {
            return -1;
        }
    }
    
    public void put(int key, int value) {
        insert(key, value);
    }

    public void insert(int key, int value) {
        if(map.containsKey(key)) {
            Node temp = map.get(key);
            map.remove(key);
            temp.prev.next = temp.next;
            temp.next.prev = temp.prev;
            Node newNode = new Node(key, value);
            newNode.next = head.next;
            newNode.prev = head;
            head.next = newNode;
            newNode.next.prev = newNode;
            map.put(key, newNode);
        }
        else {
            if(map.size() < size) {
                Node temp = new Node(key, value);
                map.put(key, temp);
                temp.next = head.next;
                head.next = temp;
                temp.next.prev = temp;
                temp.prev = head;
            }
            else {
                Node leastUsedNode = tail.prev;
                int keyData = leastUsedNode.keyData;
                map.remove(keyData);
                leastUsedNode.prev.next = tail;
                tail.prev = leastUsedNode.prev;
                Node temp = new Node(key, value);
                temp.next = head.next;
                temp.prev = head;
                temp.next.prev = temp;
                head.next = temp;
                map.put(key, temp);
            }
        }
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */