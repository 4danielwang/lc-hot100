/**
 * @description: 实现一个LRU缓存数据结构，get和put必须以O(1)运行
 * 思路: 双向链表+哈希表, 双向链表靠近头部的键值对是最近使用的, 哈希表存储在链表的位置
 */
// 时间O(1) 空间 O(capacity)
class LRUCache {

    // 最大容量
    private Integer capacity;
    // 当前大小
    private int size;

    // 伪头部和伪尾部节点
    private Node dummyhead;
    private Node dummytail;

    // 存储键值对在链表中的位置
    private Map<Integer, Node> cache = new HashMap<>();

    // 双向链表节点
    class Node{
        private Integer key;
        private Integer value;
        private Node next;
        private Node prev;
        public Node() {}
        public Node(Integer key, Integer value){
            this.key=key;
            this.value=value;
        }
    
    }

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.size = 0;
        // 使用伪头部和伪尾部节点
        dummyhead = new Node();
        dummytail = new Node();
        dummyhead.next = dummytail;
        dummytail.prev = dummyhead;
    }
    
    public int get(int key) {
        Node node = cache.get(key);
        if (node == null) {
            return -1;
        }
        // 如果 key 存在，先通过哈希表定位，再移到头部
        moveToHead(node);
        return node.value;
    }
    
    public void put(int key, int value) {
        Node node = cache.get(key);
        if (node == null) {
            // 如果 key 不存在，创建一个新的节点
            Node newNode = new Node(key, value);
            // 添加进哈希表
            cache.put(key, newNode);
            // 添加至双向链表的头部
            addToHead(newNode);
            ++size;
            if (size > capacity) {
                // 如果超出容量，删除双向链表的尾部节点
                Node tail = removeTail();
                // 删除哈希表中对应的项
                cache.remove(tail.key);
                --size;
            }
        }
        else {
            // 如果 key 存在，先通过哈希表定位，再修改 value，并移到头部
            node.value = value;
            moveToHead(node);
        }
    }
    // 将节点添加到头部
    private void addToHead(Node node) {
        node.prev = dummyhead;
        node.next = dummyhead.next;
        dummyhead.next.prev = node;
        dummyhead.next = node;
    }

    // 删除节点
    private void removeNode(Node node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    // 将节点移动到头部
    private void moveToHead(Node node) {
        removeNode(node);
        addToHead(node);
    }

    // 删除尾部节点
    private Node removeTail() {
        Node res = dummytail.prev;
        removeNode(res);
        return res;
    }
}

 