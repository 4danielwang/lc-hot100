/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    
    // 顺序表实现o1查询
    // 先拷贝val 建立了顺序表后 再来建立random关系
    public Node copyRandomList(Node head) {
        List<Node> list = new ArrayList<>();
        List<Node> list2 = new ArrayList<>(); // 新的链表节点顺序表
        Node dummy = new Node(0);
        Node rear = dummy;
        for(Node t=head;t!=null;t=t.next){
            list.add(t);
            Node u = new Node(t.val);
            list2.add(u);
            rear.next=u;
            rear=rear.next;
        }    
        rear.next=null;

        // 建立random关联
        for(int i=0;i<list.size();i++){
            Node cur = list.get(i);
            Node cur2 = list2.get(i); // 找到cur对应的新节点
            if(cur.random!=null){ // 如果有random
                int idx = list.indexOf(cur.random);
                cur2.random = list2.get(idx); 
            }
        }
        return dummy.next;
    }
}