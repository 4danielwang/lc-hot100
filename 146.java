import java.util.*;

class LRUCache {

    // LRU 容量，映射，dummy节点
    private Integer capacity;

    private final Node dummy = new Node(0, 0);

    // 节点插入和删除要更新映射
    private final Map<Integer, Node> keyToNode = new HashMap<>();

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
    
    public int get(int key) {
        Node x = getNode(key);

        if(x!=null)
            return x.value;
        return -1;
    }
    
    public void put(int key, int value) {
        Node x = getNode(key);
        if(x!=null){
            x.value = value;
            return;
        }
        x = new Node(key, value);
        pushFront(x);
        keyToNode.put(key, x);
        // 删除lru末尾的节点
        if(keyToNode.size() > capacity){
            Node r = dummy.prev;
            keyToNode.remove(r.key);
            remove(r);
        }

    }


    // 访问节点 把节点放在头部 LRU规则
    private Node getNode(Integer key){
        if(!keyToNode.containsKey(key))
            return null;
        Node t = keyToNode.get(key);
        remove(t);
        pushFront(t);

        return t;
    }

    // 取出节点
    private void remove(Node x){
        x.prev.next = x.next;
        x.next.prev = x.prev;
    }

    /**
     * 头部插入节点
     * @param xp
     */
    private void pushFront(Node x){
        x.next = dummy.next;
        x.prev = dummy;
        dummy.next.prev = x;
        dummy.next=x;

    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */

 