import java.util.HashMap;

@SuppressWarnings("all")
public class LRUCache {

    private HashMap<Integer, Node> nodeHashMap;
    private Node head;
    private Node tail;
    private int capacity;

    /**
     * 初始化方法 链表头和链表尾
     *
     * @param capacity
     */
    public LRUCache(int capacity) {
        nodeHashMap = new HashMap<>(capacity);
        head = new Node();
        tail = new Node();
        head.next = tail;
        tail.prev = head;
        this.capacity = capacity;
    }

    public int get(int key) {
        if (!nodeHashMap.containsKey(key)) {
            return -1;
        }
        Node node = nodeHashMap.get(key);
        node = deleteNode(node);
        addFirstNode(node);
        return node.val;
    }

    public void put(int key, int value) {
        // 注意点1: 依旧存在的KEY需要删除
        if (nodeHashMap.containsKey(key)) {
            deleteNode(nodeHashMap.get(key));
            nodeHashMap.remove(key);
        }
        // 注意点2: 删除后再统计size
        int size = nodeHashMap.size();
        if (size == capacity) {
            // 删除最后一个
            Node node = deleteNode(tail.prev);
            nodeHashMap.remove(node.key);
        }
        Node node = new Node(value, key);
        addFirstNode(node);
        nodeHashMap.put(key, node);
    }

    private void addLastNode(Node node) {
        if (node == null) {
            throw new IllegalArgumentException("node cant be null");
        }
        Node temp = tail.prev;
        tail.prev = node;
        node.next = tail;
        node.prev = temp;
        temp.next = node;
    }

    private void addFirstNode(Node node) {
        if (node == null) {
            throw new IllegalArgumentException("node cant be null");
        }
        Node temp = head.next;
        head.next = node;
        node.prev = head;
        node.next = temp;
        temp.prev = node;
    }


    private Node deleteNode(Node node) {
        Node prev = node.prev;
        Node next = node.next;
        prev.next = next;
        next.prev = prev;
        node.prev = null;
        node.next = null;
        return node;
    }

    public static class Node {
        private int val;
        private int key;
        private Node prev;
        private Node next;

        public Node() {
        }

        public Node(int val, int key) {
            this.val = val;
            this.key = key;
        }
    }

    public static void main(String[] args) {
        LRUCache lruCache = new LRUCache(2);
        lruCache.put(2, 6);
        lruCache.put(1, 5);
        lruCache.put(1, 2);
        System.out.println(lruCache.get(1));
        System.out.println(lruCache.get(2));
    }
}