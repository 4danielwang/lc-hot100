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
    public ListNode deleteDuplicates(ListNode head) {
        // 不足2个节点
        if(head == null || head.next == null) return head;
        
        ListNode dummy = new ListNode(0, head);
        ListNode cur = dummy;
        // 根据三个节点来判断cur,cur.next,cur.next.next
        // 后面的元素到尾了
        while(cur.next != null && cur.next.next != null){
            // 先判断后两个元素相等
            if(cur.next.val == cur.next.next.val){
                int x = cur.next.val; // 相等的节点值
                // 删除等于x的节点
                while(cur.next != null && cur.next.val == x){
                    cur.next = cur.next.next;
                }
            }else{
                cur = cur.next; // 后面两个节点不相等
            }
        }
        return dummy.next;
    }
}