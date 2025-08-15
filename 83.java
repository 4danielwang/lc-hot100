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
        if(head == null){
            return null;
        }

        ListNode cur = head;
        // cur.next==null代表cur已经是最后一个节点
        // 每次只需要看cur.next
        // 相等就删除cur.next
        // 不等就移动cur
        while(cur.next != null){
          if(cur.val == cur.next.val){
            cur.next = cur.next.next;
          }else{
            cur = cur.next;
          }
        }
        return head;
    }
}