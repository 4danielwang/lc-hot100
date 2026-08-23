/**
 * @description: 删除排序链表中的重复元素， 使得每个元素只出现一次，返回链表的头指针
 * @example: 输入: 1->1->2, 输出: 1->2
 * @example: 输入: 1->1->2->3->3, 输出: 1->2->3
 * 思路：重复元素在链表中一定是连续的，判断cur和cur.next是否相等，相等就删除cur.next，不相等就移动cur
 */
class Solution {
    // 时间O(n) 空间O(1)
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