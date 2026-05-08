/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    // 数组记录 随机访问
    private List<ListNode> list = new ArrayList<>();
    public ListNode swapPairs(ListNode head) {
        // 少于2个节点
        if(head == null || head.next == null){
            return head;
        }
        for(ListNode p =head;p!=null;p=p.next){
            list.add(p);
        }
        
        // 交换两个元素位置
        for(int i=0;i<list.size();i+=2){
            if(i+1 <list.size()){
                Collections.swap(list, i, i+1);
            }
        }
        ListNode dummy = new ListNode(0, null);
        ListNode rear = dummy;
        for(ListNode t : list){
            rear.next = t;
            rear = rear.next;
        }
        rear.next = null;
        return dummy.next;
        
    }
}
