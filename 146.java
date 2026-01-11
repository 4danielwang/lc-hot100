import java.util.*;

// get/put O(1) 时间
// 空间 O(capacity)
class LRUCache {

    // LRU 容量
    private Integer capacity;

    // dummy节点
    private final Node dummy = new Node(0, 0);

    // 值到节点的映射
    // 节点插入和删除要更新映射
    private final Map<Integer, Node> keyToNode = new HashMap<>();

    // 双向链表节点
    public static class Node{
        private Integer key;
        private Integer value;
        private Node next;
        private Node prev;

        public Node(Integer key, Integer value){
            this.key=key;
            this.value=value;
        }
    
    }

    public LRUCache(int capacity) {
        this.capacity = capacity;
        dummy.prev = dummy;
        dummy.next = dummy;
    }
    
    // 根据key获取值
    public int get(int key) {
        Node x = getNode(key);

        if(x!=null)
            return x.value;
        return -1;
    }
    
    // 根据key设置值
    public void put(int key, int value) {
        Node x = getNode(key);
        if(x!=null){
            x.value = value;
            return;
        }
        x = new Node(key, value);
        pushFront(x);
        keyToNode.put(key, x);

        // 超过capacity 删除尾节点
        if(keyToNode.size() > capacity){
            Node r = dummy.prev;
            keyToNode.remove(r.key);
            remove(r);
        }

    }

    // 访问节点 包含LRU逻辑
    private Node getNode(Integer key){
        if(!keyToNode.containsKey(key))
            return null;
        Node t = keyToNode.get(key);
        remove(t);
        pushFront(t);
        return t;
    }

    // 删除节点
    private void remove(Node x){
        x.prev.next = x.next;
        x.next.prev = x.prev;
    }

    // 插入节点到头部
    private void pushFront(Node x){
        x.next = dummy.next;
        x.prev = dummy;
        dummy.next.prev = x;
        dummy.next=x;
    }
}

 