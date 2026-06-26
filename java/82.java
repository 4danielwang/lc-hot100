/**
 * @description: 删除原始链表中所有重复数字的节点,只留下不同的数字
 * @example: [1,2,3,3,4,4,5] -> [1,2,5]
 */
class Solution {
    // 时间O(n) 空间O(1)
    public ListNode deleteDuplicates(ListNode head) {
        ListNode dummy = new ListNode(0, head);
        ListNode cur = dummy;
        
        while(cur.next != null && cur.next.next != null){
            // 先判断后两个元素相等
            if(cur.next.val == cur.next.next.val){
                int x = cur.next.val; // 相等的节点值
                // 连续删除next值等于cur值的节点
                while(cur.next != null && cur.next.val == x){
                    cur.next = cur.next.next;
                }
            }else{
                // 处理下一个
                cur = cur.next;
            }
        }
        return dummy.next;
    }
}